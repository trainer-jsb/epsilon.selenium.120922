package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPO {

	private WebDriver driver;

	public SearchResultsPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")
	private List<WebElement> searchResults;

	@FindBy(id = "nav-cart-count")
	private WebElement cartCount;

	// Methods go here
	public List<WebElement> returnSearchResult() {
		return searchResults;
	}

	public void clickOnProduct(int number) {
		searchResults.get(number).click();
	}

	public String returnCartCount() {
		return cartCount.getText();
	}
}
