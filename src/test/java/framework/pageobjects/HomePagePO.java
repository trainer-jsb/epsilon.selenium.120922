package framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePO {
	
	private WebDriver driver;
	
	public HomePagePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchTextBox;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement searchBtn;
	
	public void enterProductName(String strProdName) {
		searchTextBox.clear();
		searchTextBox.sendKeys(strProdName);
	}

	public void clickSearchButton() {
		searchBtn.click();
	}
}
