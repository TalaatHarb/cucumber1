package pages.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPageElementsLocator {
	
	@FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/div/div[1]/div[1]/div[1]/h1/span[1]")
	public WebElement resultsSpan;
	
	public SearchResultsPageElementsLocator(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
}
