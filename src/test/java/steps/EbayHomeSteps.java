package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import utils.WebDriverUtils;

@Slf4j
public class EbayHomeSteps {

	private static final String HOME_PAGE_URL = "https://www.ebay.com/";
	private static final String ADVANCED_SEARCH_PAGE_URL = "https://www.ebay.com/sch/ebayadvsearch";
	private WebDriver webDriver;

	@Given("I am on Ebay Home page")
	public void iAmOnEbayHomePage() {
		webDriver = WebDriverUtils.createWebDriver();

		webDriver.get(HOME_PAGE_URL);

		log.info("I am on Ebay Home page");
	}

	@When("I click on Advanced Link")
	public void iClickOnAdvancedLink() {
		webDriver.findElement(By.linkText("Advanced")).click();
		log.info("I click on Advanced Link");
	}

	@Then("I naviagate to the Advanced Search page")
	public void iNaviagateToTheAdvancedSearchPage() {
		String currentURL = webDriver.getCurrentUrl();
		assertEquals(ADVANCED_SEARCH_PAGE_URL, currentURL);
		webDriver.quit();
		log.info("I naviagate to the Advanced Search page");
	}
}
