package pages.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPageElementsLocator {
	
	@FindBy(css = "div[class='srp-controls__control srp-controls__count'] span:nth-child(1)")
	public WebElement resultsSpan;
	
	public SearchResultsPageElementsLocator(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
}
