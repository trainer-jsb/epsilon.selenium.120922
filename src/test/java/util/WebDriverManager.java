package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class WebDriverManager {
	
	/***
	 * This method will invoke the browser as per the arguments
	 * @param browserName		Browser name should be chrome or edge
	 */
	public WebDriver launchBrowser(String browserName) {
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			Assert.fail("FAIL | Corect browser name should be chrome or edge");
		}
		driver.manage().window().maximize();
		return driver;
	}
}