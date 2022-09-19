package framework.functionlibrary;

import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.pageobjects.SearchResultsPO;

public class SearchResultsLib {
	
	private WebDriver driver;
	
	public SearchResultsLib(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<String> returnNameofProducts() {
		SearchResultsPO searespo = new SearchResultsPO(this.driver);
		List<WebElement> listOfProd = searespo.returnSearchResult();
		List<String> nameOfProd = new LinkedList<String>();
		
		for(WebElement oelem: listOfProd) {
			nameOfProd.add(oelem.getText().trim().toLowerCase());
		}
		return nameOfProd;
	}
	
	public void clickOnFirstProduct() {
		SearchResultsPO searespo = new SearchResultsPO(this.driver);
		searespo.clickOnProduct(0);
	}
	
	public int returnCartCount() {
		SearchResultsPO searespo = new SearchResultsPO(this.driver);
		return Integer.parseInt(searespo.returnCartCount());
	}
	
}