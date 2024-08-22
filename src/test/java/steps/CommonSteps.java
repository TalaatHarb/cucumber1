package steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import utils.PageUtils;
import utils.WebDriverUtils;

@Slf4j
public class CommonSteps {
	
	@Getter
	private WebDriver webDriver;
	
	@Before
	public void commonSetup() {
		webDriver = WebDriverUtils.createWebDriver();
	}
	
	@After
	public void commonTearDown() {
		webDriver.quit();
	}
	
	@Before("@Navigation")
	public void navigationScenariosSetup() {
		log.info("Navigation scenario");
	}
	
	@Before("@Search")
	public void searchScenariosSetup() {
		log.info("Search scenario");
	}
	
	@Before("@Home")
	public void homePageScenariosSetup() {
		log.info("Home Page scenario");
	}
	
	@Before("@AdvancedSearch")
	public void advancedSearchPageScenariosSetup() {
		log.info("Advanced search Page scenario");
	}
	
	@Given("I am on Ebay {string} page")
	public void iAmOnPage(String pageName) {
		webDriver.get(PageUtils.mapPageNameToURL(pageName));

		log.info("I am on Ebay {} page", pageName);
	}
	
	@Then("I naviagate to the {string} page")
	public void iNaviagateToPage(String pageName) {
		String currentURL = webDriver.getCurrentUrl();
		log.info("Current page url: {}", currentURL);
		
		assertTrue(currentURL.contains(PageUtils.mapPageNameToURL(pageName)));
		log.info("I naviagate to the {} page", pageName);
	}
	
	@Then("I confirm page title contains {string}")
	public void iConfirmPageTitleContains(String title) {
	    String currentTitle = webDriver.getTitle();
	    log.info("Current page title: {}", currentTitle);
	    
	    assertTrue(currentTitle.contains(title));
		log.info("I naviagate to the page with title: {}", title);
	}

}
