package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EbayAdvancedSearchSteps {
	private WebDriver webDriver;
	
	public EbayAdvancedSearchSteps(CommonSteps commonSteps) {
		webDriver = commonSteps.getWebDriver();
	}

	@When("I click on Ebay logo")
	public void iClickOnEbayLogo() {
		var ebayLogo = webDriver.findElement(By.xpath("//*[@id='gh-logo']"));
		ebayLogo.click();
		log.info("I click on Ebay logo");
	}
}
