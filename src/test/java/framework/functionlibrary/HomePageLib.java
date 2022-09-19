package framework.functionlibrary;

import org.openqa.selenium.WebDriver;

import framework.pageobjects.HomePagePO;
import util.WebDriverUtil;

public class HomePageLib {
	
	private WebDriver driver;
	
	public HomePageLib(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct(String strProdName) {
		HomePagePO hompo = new HomePagePO(this.driver);
		hompo.enterProductName(strProdName);
		hompo.clickSearchButton();
		
		WebDriverUtil webdrvutil = new WebDriverUtil(this.driver);
		webdrvutil.waitForPageToLoad(120);
	}

}
