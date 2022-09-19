package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class InputBox {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test
	public void inputBoxTest() {	
		String expected = "this is a test method";
		WebElement oInputBox = driver.findElement(By.id("user-message"));
		oInputBox.clear();
		oInputBox.sendKeys(expected);
		
		driver.findElement(By.xpath("//button[@class='btn btn-default'][text()='Show Message']")).click();
		String actual = driver.findElement(By.id("display")).getText();
		Assert.assertEquals(actual, expected);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
