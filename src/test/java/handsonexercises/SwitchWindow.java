package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.WebDriverManager;
import util.WebDriverUtil;

public class SwitchWindow {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	WebDriverWait wait;
	WebDriverUtil webdrvutil;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		webdrvutil = new WebDriverUtil(driver);
		driver.get("https://demoqa.com/browser-windows/");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test
	public void switchWindow() throws InterruptedException {	
		driver.findElement(By.id("tabButton")).click();
		System.out.println("Original window URL is " +driver.getCurrentUrl());
		webdrvutil.switchWindow();
		
		System.out.println("New window URL is " +driver.getCurrentUrl());
		//code goes here
		driver.close();
		
		webdrvutil.switchWindow();
		System.out.println("New window URL is " +driver.getCurrentUrl());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
