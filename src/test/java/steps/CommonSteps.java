package steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pages.CommonActions;
import utils.PageUtils;

@RequiredArgsConstructor
@Slf4j
public class CommonSteps {

	private final CommonActions commonActions;

	@Given("I am on Ebay {string} page")
	public void iAmOnPage(String pageName) {
		commonActions.goToURL(PageUtils.mapPageNameToURL(pageName));
		log.info("I am on Ebay {} page", pageName);
	}

	@Then("I naviagate to the {string} page")
	public void iNaviagateToPage(String pageName) {
		String currentURL = commonActions.getCurrnetPageURL();
		log.info("Current page url: {}", currentURL);

		assertTrue(currentURL.contains(PageUtils.mapPageNameToURL(pageName)));
		log.info("I naviagate to the {} page", pageName);
	}

	@Then("I confirm page title contains {string}")
	public void iConfirmPageTitleContains(String title) {
		String currentTitle = commonActions.getCurrentPageTitle();
		log.info("Current page title: {}", currentTitle);

		assertTrue(currentTitle.contains(title));
		log.info("I naviagate to the page with title: {}", title);
	}

}
