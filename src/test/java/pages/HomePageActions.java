package pages;

import hooks.GlobalHooks;
import pages.locators.HomePageElementsLocator;

public class HomePageActions {

	private final HomePageElementsLocator homePageElements;

	public HomePageActions(GlobalHooks globalHooks) {
		var webDriver = globalHooks.getWebDriver();
		this.homePageElements = new HomePageElementsLocator(webDriver);
	}

	public void enterSearchTerm(String searchTerm) {
		homePageElements.searchBox.sendKeys(searchTerm);
	}

	public void clickSearchButton() {
		homePageElements.searchButton.click();
	}

	public void clickOnCategoryMenu() {
		homePageElements.categoriesMenu.click();
	}

	public void clickOnCategory(String category) {
		var categories = homePageElements.categories;

		for (var categoryElement : categories) {
			if (category.equals(categoryElement.getText())) {
				categoryElement.click();
				break;
			}
		}
	}
}
