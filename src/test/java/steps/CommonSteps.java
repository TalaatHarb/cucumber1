package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.Getter;
import utils.WebDriverUtils;

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

}
