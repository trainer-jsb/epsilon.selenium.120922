package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;
import util.WebDriverUtil;

public class MouseHover {
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
		driver.get("https://demoqa.com/menu/");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test
	public void mouseHoverTest() throws InterruptedException {	
		WebElement mainItem2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		WebElement subSubList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(mainItem2).perform();
		Thread.sleep(5000);
		action.moveToElement(subSubList).perform();
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
