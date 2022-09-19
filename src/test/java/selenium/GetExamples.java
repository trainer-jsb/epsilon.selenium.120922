package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class GetExamples {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome") String browser) {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser(browser);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test
	public void getGoogleExample() {
		driver.get("https://www.google.co.in");
		String pageTitle = driver.getTitle();
		sf.assertEquals(pageTitle, "Google");

		String currenturl = driver.getCurrentUrl();
		sf.assertEquals(currenturl, "https://www.google.co.in/");
		
		sf.assertAll();
	}
	
	public void getZAmazonExample() {
		driver.get("https://www.amazon.co.in");
		String pageTitle = driver.getTitle();
		sf.assertEquals(pageTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");

		String currenturl = driver.getCurrentUrl();
		sf.assertEquals(currenturl, "https://www.amazon.in/");
		
		String locale = driver.findElement(By.cssSelector("span.nav-logo-locale")).getText();
		sf.assertEquals(locale, ".in");
		
		sf.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}