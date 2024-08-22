package pages;

import hooks.GlobalHooks;
import pages.locators.AdvancedSearchPageElementsLocator;

public class AdvancedSearchPageActions {
	private final AdvancedSearchPageElementsLocator advancedSearchPageElements;
	
	public AdvancedSearchPageActions(GlobalHooks globalHooks) {
		var webDriver = globalHooks.getWebDriver();
		advancedSearchPageElements = new AdvancedSearchPageElementsLocator(webDriver);
	}
	
	public void clickOnEbayLogo() {
		advancedSearchPageElements.ebayLogo.click();
	}
	
	public void enterSearchTerm(String searchTerm) {
		advancedSearchPageElements.searchInputBox.sendKeys(searchTerm);
	}
	
	public void enterExcludeTerm(String excludeTerm) {
		advancedSearchPageElements.excludeInputBox.sendKeys(excludeTerm);
	}
	
	public void enterMinimumPrice(String minPrice) {
		advancedSearchPageElements.minPriceBox.sendKeys(minPrice);
	}
	
	public void enterMaximumPrice(String maxPrice) {
		advancedSearchPageElements.maxPriceBox.sendKeys(maxPrice);
	}
	
	public void clickSearchButton() {
		advancedSearchPageElements.searchButton.click();
	}
}
