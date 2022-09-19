package framework.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import framework.functionlibrary.HomePageLib;
import framework.functionlibrary.ProductDetailLib;
import framework.functionlibrary.SearchResultsLib;
import util.DataProviderLayer;
import util.WebDriverManager;
import util.WebDriverUtil;

public class SearchProductsTest {

	private WebDriver driver;
	private WebDriverManager webdrvmgr;
	private SoftAssert sf;
	
	//Arrange
	String filepath = "src/test/resources/base.prop";
	String url = DataProviderLayer.getPropertyValue(filepath, "url");
	String searchParam = DataProviderLayer.getPropertyValue(filepath, "searchParam");
	int timeout = Integer.parseInt(DataProviderLayer.getPropertyValue(filepath, "timeout"));
	
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome") String browser) {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser(browser);
		driver.get(url);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		sf = new SoftAssert();
	}
	
	@Test(priority = 1)
	public void testProductName() {
		HomePageLib hompaglib = new HomePageLib(driver);
		hompaglib.searchProduct(searchParam);
		
		SearchResultsLib seareslib = new SearchResultsLib(driver);
		List<String> prodNames = seareslib.returnNameofProducts();
		for(String prodName: prodNames) {
			sf.assertTrue(prodName.contains(searchParam), "FAIL | Actual " +prodName+ " doesn't contain search parameter " +searchParam);
		}
		sf.assertAll();
	}
	
	@Test (priority = 2, dependsOnMethods = "testProductName", alwaysRun = true)
	public void testAddProductToCart() {
		SearchResultsLib seareslib = new SearchResultsLib(driver);
		int oldCartCount = seareslib.returnCartCount();
		seareslib.clickOnFirstProduct();
		
		WebDriverUtil webdrvutl = new WebDriverUtil(driver);
		webdrvutl.switchWindow();
		
		ProductDetailLib proddtlib = new ProductDetailLib(driver);
		proddtlib.clickOnAddToCart();
		
		driver.close();
		webdrvutl = new WebDriverUtil(driver);
		webdrvutl.switchWindow();
		driver.navigate().refresh();
		webdrvutl.waitForPageToLoad(oldCartCount);
		
		seareslib = new SearchResultsLib(driver);
		int newCartCount = seareslib.returnCartCount();
		
		Assert.assertEquals(newCartCount, oldCartCount+1);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
