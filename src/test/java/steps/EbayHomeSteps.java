package steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import hooks.GlobalHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EbayHomeSteps {

	private final WebDriver webDriver;
	
	public EbayHomeSteps(GlobalHooks globalHooks) {
		webDriver = globalHooks.getWebDriver();
	}


	@When("I click on {string} Link")
	public void iClickOnAdvancedLink(String linkName) {
		webDriver.findElement(By.linkText(linkName)).click();
		log.info("I click on {} Link", linkName);
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

	@When("I search for {string} in category {string}")
	public void iSearchForItemInCategory(String item, String category) {
		var searchBox = webDriver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
		searchBox.click();
		searchBox.sendKeys(item);

		var categoriesMenu = webDriver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));
		categoriesMenu.click();
		var categories = webDriver.findElements(By.xpath("//*[@id=\"gh-cat\"]/option"));
		
		for(var categoryElement: categories) {
			if(category.equals(categoryElement.getText())) {
				categoryElement.click();
				break;
			}
		}
		

		var searchButton = webDriver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
		searchButton.click();

		log.info("I search for {string}", item);
	}

	@Then("I confirm at least {int} results")
	public void iConfirmResultsCount(Integer minCount) {

		var resultsSpan = webDriver
				.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[1]/div[1]/div[1]/h1/span[1]"));
		int result = Integer.parseInt(resultsSpan.getText().replace(",", ""));

		log.info("Found {} result", result);

		assertTrue(result >= minCount);

		log.info("I confirm at least {} results", minCount.toString());
	}
}
