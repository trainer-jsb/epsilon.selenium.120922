package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class AlertBox {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test
	public void jsConfirmBoxTest() {
		driver.findElement(By.xpath("//button[text()='Click me!'][@class='btn btn-default btn-lg']")).click();
		driver.switchTo().alert().accept();
		String actual = driver.findElement(By.id("confirm-demo")).getText();
		sf.assertEquals(actual, "You pressed OK!");
		
		driver.findElement(By.xpath("//button[text()='Click me!'][@class='btn btn-default btn-lg']")).click();
		driver.switchTo().alert().dismiss();
		actual = driver.findElement(By.id("confirm-demo")).getText();
		sf.assertEquals(actual, "You pressed Cancel!");
		sf.assertAll();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
