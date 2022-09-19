package framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.WebDriverUtil;

public class ProductDetailPO {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private WebDriverUtil webdrvutil;
	int timeout = 120;
	
	public ProductDetailPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	//All PO's to go here
	@FindBy(id="add-to-cart-button")
	private WebElement addToCart;
	
	@FindBy(id="attach-close_sideSheet-link")
	private WebElement closeSidePane;
	
	
	//All methods should go here
	public void clickOnAddToCart() {
		wait = new WebDriverWait(this.driver, timeout);
		webdrvutil = new WebDriverUtil(this.driver);
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		webdrvutil.scrollIntoView(addToCart);
		addToCart.click();
	}
	
	public void clickOnCloseSidePane() {
		wait = new WebDriverWait(this.driver, timeout);
		webdrvutil = new WebDriverUtil(this.driver);
		wait.until(ExpectedConditions.elementToBeClickable(closeSidePane));
		webdrvutil.scrollIntoView(closeSidePane);
		closeSidePane.click();
	}	
}