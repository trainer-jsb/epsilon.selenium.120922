package handsonexercises;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class DatePicker {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@SuppressWarnings("unused")
	@Test
	public void jsConfirmBoxTest() {
		String[] expdaysofweek = { "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su" };

		driver.findElement(By.xpath("//div[@id='sandbox-container1']//span[@class='input-group-addon']")).click();
		List<WebElement> dow = driver.findElements(By.className("dow"));

		// Assert that first day of week is Monday
		String firstdow = dow.get(0).getText();
		sf.assertEquals(firstdow, expdaysofweek[0]);
		// Assert that there are 7 days showing in a week
		int countofdow = dow.size();
		sf.assertEquals(countofdow, 7);

		//Assert that today date is highlighted
		String actualtodaysdate = driver.findElement(By.className("today day")).getText();
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		String expectedtodaysdate = dateFormat.format(date);
		sf.assertEquals(actualtodaysdate, expectedtodaysdate);

		//Assert the days of week text
		for (int loop = 0; loop < dow.size(); loop ++) {
			String  actualdaysofweek = dow.get(loop).getText();
			sf.assertEquals(actualdaysofweek, expdaysofweek[loop]);
		}
		
		//Code to check for disabled future dates
		List<WebElement> listFutureDates = driver.findElements(By.className("disabled day"));
		String strTomorrowDate = listFutureDates.get(0).getText();
		//parse this to int
		//parse expectedtodaysdate to int
		//sf.assertTrue(tomorrowdate>expectedtoday's date)
		
		sf.assertAll();

	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
