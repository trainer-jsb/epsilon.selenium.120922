package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import util.WebDriverManager;

public class LaunchBrowser {
	
	@Test
	public void launchChromeBrowser() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//write test here
		driver.quit();
	}
	
	@Test
	public void launchEdgeBrowser() {
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.quit();
	}
	
	@Test
	public void launchBrowserViaWebDriverManager() {
		WebDriverManager webdrvmgr = new WebDriverManager();
		WebDriver driver = webdrvmgr.launchBrowser("chrome");
		driver.quit();
	}

}
