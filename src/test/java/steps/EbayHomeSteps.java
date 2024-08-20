package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EbayHomeSteps {
	
	public EbayHomeSteps(CommonSteps commonSteps) {
		webDriver = commonSteps.getWebDriver();
	}

	private WebDriver webDriver;

	@Given("I am on Ebay Home page")
	public void iAmOnEbayHomePage() {
		webDriver.get(EbayConstants.HOME_PAGE_URL);

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
		assertEquals(EbayConstants.ADVANCED_SEARCH_PAGE_URL, currentURL);
		log.info("I naviagate to the Advanced Search page");
	}
	
	@When("I search for {string}")
	public void iSearchForItem(String item) {
		var searchBox = webDriver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
		searchBox.click();
		searchBox.sendKeys(item);
		
		var searchButton = webDriver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
		searchButton.click();
		
		log.info("I search for {string}", item);
	}
	@Then("I confirm at least {int} results")
	public void iConfirmResultsCount(Integer minCount) {
		
		var resultsSpan = webDriver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[1]/div[1]/div[1]/h1/span[1]"));
		int result = Integer.parseInt(resultsSpan.getText().replace(",", ""));
		
		log.info("Found {} result", result);
		
		assertTrue(result >= minCount);
		
	    log.info("I confirm at least {} results", minCount.toString());
	}
}
