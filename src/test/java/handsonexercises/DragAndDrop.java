package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.WebDriverManager;
import util.WebDriverUtil;

public class DragAndDrop {

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
		driver.get("https://demoqa.com/droppable/");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test
	public void dragAndDropTest() {	
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		webdrvutil.scrollIntoView(source);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
		
		String actual = target.getText();
		Assert.assertEquals(actual, "Dropped!");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
