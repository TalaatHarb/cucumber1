package steps;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pages.CommonActions;
import pages.HomePageActions;

@RequiredArgsConstructor
@Slf4j
public class EbayHomeSteps {

	private final CommonActions commonActions;
	private final HomePageActions homePage;

	@When("I click on {string} Link")
	public void iClickOnLink(String linkName) {
		commonActions.clickOnLink(linkName);
		log.info("I click on {} Link", linkName);
	}

	@When("I search for {string}")
	public void iSearchForItem(String item) {
		homePage.enterSearchTerm(item);
		homePage.clickSearchButton();

		log.info("I search for {string}", item);
	}

	@When("I search for {string} in category {string}")
	public void iSearchForItemInCategory(String item, String category) {
		homePage.enterSearchTerm(item);
		homePage.clickOnCategoryMenu();
		homePage.clickOnCategory(category);
		homePage.clickSearchButton();

		log.info("I search for {string}", item);
	}
}
