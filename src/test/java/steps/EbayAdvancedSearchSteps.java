package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EbayAdvancedSearchSteps {

	@Given("I am on Advanced search page")
	public void iAmOnAdvancedSearchPage() {
		log.info("I am on Advanced search page");
	}

	@When("I click on Ebay logo")
	public void iClickOnEbayLogo() {
		log.info("I click on Ebay logo");
	}

	@Then("I naviagate to the Home page")
	public void iNaviagateToTheHomePage() {
		log.info("I naviagate to the Home page");
	}
}
