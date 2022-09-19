package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class ProgressBar {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		driver.get("https://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test
	public void progressBarTest() {	
		By downloadBtn = By.id("downloadButton");
		driver.findElement(downloadBtn).click();
		By cancelBtn = By.cssSelector("div.progress-label");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(cancelBtn, "Complete!"));
		
		driver.findElement(By.xpath("//button[text()='Close']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}