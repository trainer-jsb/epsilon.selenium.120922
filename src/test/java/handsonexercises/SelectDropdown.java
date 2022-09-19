package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class SelectDropdown {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test
	public void selectTest() {	
		WebElement odropdown = driver.findElement(By.id("select-demo"));
		Select select = new Select(odropdown);
		select.selectByVisibleText("Wednesday");
		select.selectByValue("Tuesday");
		select.selectByIndex(6);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
