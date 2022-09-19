package util;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {

	private WebDriver driver;
	private Utilities util;

	public WebDriverUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollIntoView(WebElement oelem) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", oelem);
	}

	public void switchWindow() {
		String oldWindow = null;
		try {
			oldWindow = driver.getWindowHandle();
		} catch (Exception e) {
			System.out.println("Target window was closed");
		}
		Set<String> windows = driver.getWindowHandles();

		for (String newWindow : windows) {
			if (!newWindow.equalsIgnoreCase(oldWindow)) {
				driver.switchTo().window(newWindow);
				break;
			}
		}
	}

	public void waitForPageToLoad(int timeOut) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return (js.executeScript(("return document.readyState")).equals("complete"));
			}
		};
		WebDriverWait wait = new WebDriverWait(this.driver, timeOut);
		wait.until(expectation);
	}

	public void waitForAjaxToLoad(int timeOut) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
			}
		};
		WebDriverWait wait = new WebDriverWait(this.driver, timeOut);
		wait.until(expectation);
	}

	public void takeScreenshot(String filename) throws IOException {
		util = new Utilities();
		File scrFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/test-output/" + filename + util.timestamp() + ".png"));
	}
}