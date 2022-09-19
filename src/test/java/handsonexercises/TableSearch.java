package handsonexercises;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.WebDriverManager;

public class TableSearch {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test
	public void tableSearchTest() {	
		String searchParam = "pr";
		WebElement oInput = driver.findElement(By.id("task-table-filter"));
		oInput.clear();
		oInput.sendKeys(searchParam);
		
		List<WebElement>olist = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		for(WebElement oelem: olist) {
			String attribstyle = oelem.getAttribute("style");
			if(!attribstyle.equals("display: none;")) {
				String actual = oelem.getText();
				sf.assertTrue(actual.contains(searchParam), "FAIL | Actual " +actual+ " didn't contact search param " +searchParam);
			}
		}
		sf.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
