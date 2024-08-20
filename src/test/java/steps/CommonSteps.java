package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	
	@Given("I am on Ebay {string} page")
	public void iAmOnPage(String pageName) {
		webDriver.get(PageUtils.mapPageNameToURL(pageName));

		log.info("I am on Ebay Home page");
	}
	
	@Then("I naviagate to the {string} page")
	public void iNaviagateToPage(String pageName) {
		String currentURL = webDriver.getCurrentUrl();
		assertEquals(PageUtils.mapPageNameToURL(pageName), currentURL);
		log.info("I naviagate to the Advanced Search page");
	}

}
