package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class Frames {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("https://demoqa.com/frames");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test
	public void framesTest() {	
		driver.switchTo().frame("frame1");
		String name = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(name);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}