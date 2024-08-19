package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EbayHomeSteps {

	@Given("I am on Ebay Home page")
	public void i_am_on_ebay_home_page() {
		log.info("Opening Ebay Home page");
	}

	@When("I click on Advanced Link")
	public void i_click_on_advanced_link() {
		log.info("Clicking on advanced link");
	}

	@Then("I naviagate to the Advanced Search page")
	public void i_naviagate_to_the_advanced_search_page() {
		log.info("Confirm navigating to Advanced search page");
	}
}
