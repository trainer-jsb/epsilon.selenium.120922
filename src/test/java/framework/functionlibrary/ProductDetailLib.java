package framework.functionlibrary;

import org.openqa.selenium.WebDriver;

import framework.pageobjects.ProductDetailPO;

public class ProductDetailLib {
	
	private WebDriver driver;
	private ProductDetailPO proddetpo;
	
	public ProductDetailLib(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnAddToCart() {
		proddetpo = new ProductDetailPO(this.driver);
		proddetpo.clickOnAddToCart();
		proddetpo.clickOnCloseSidePane();
	}
}