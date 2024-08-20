package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EbayHomeSteps {

	@Given("I am on Ebay Home page")
	public void iAmOnEbayHomePage() {
		log.info("Opening Ebay Home page");
	}

	@When("I click on Advanced Link")
	public void iClickOnAdvancedLink() {
		log.info("Clicking on advanced link");
	}

	@Then("I naviagate to the Advanced Search page")
	public void iNaviagateToTheAdvancedSearchPage() {
		log.info("Confirm navigating to Advanced search page");
	}
}
