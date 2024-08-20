package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
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

}
