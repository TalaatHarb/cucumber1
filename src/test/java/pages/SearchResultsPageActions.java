package pages;

import hooks.GlobalHooks;
import pages.locators.SearchResultsPageElementsLocator;

public class SearchResultsPageActions {

	private SearchResultsPageElementsLocator searchResultsPageElements;

	public SearchResultsPageActions(GlobalHooks globalHooks) {
		var webDriver = globalHooks.getWebDriver();
		this.searchResultsPageElements = new SearchResultsPageElementsLocator(webDriver);
	}

	public Integer getResultsCount() {
		return Integer.parseInt(searchResultsPageElements.resultsSpan.getText().replace(",", ""));
	}
}
