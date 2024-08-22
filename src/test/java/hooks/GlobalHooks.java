package hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.Getter;
import utils.WebDriverUtils;

public class GlobalHooks {
	
	@Getter
	private WebDriver webDriver;

	@Before(order = 100)
	public void commonSetup() {
		webDriver = WebDriverUtils.createWebDriver();
	}

	@After(order = 100)
	public void commonTearDown() {
		webDriver.quit();
	}
}
