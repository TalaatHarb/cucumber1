package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
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

	@When("I do advanced search")
	public void iDoAdvancedSearch(DataTable dataTable) {
		webDriver.findElement(By.xpath("//*[@id=\"_nkw\"]")).sendKeys(dataTable.cell(1, 0));
		webDriver.findElement(By.xpath("//*[@id=\"_ex_kw\"]")).sendKeys(dataTable.cell(1, 1));
		webDriver.findElement(By.cssSelector("[aria-label=\"Enter minimum price range value, $\"]"))
				.sendKeys(dataTable.cell(1, 2));
		webDriver.findElement(By.cssSelector("[aria-label=\"Enter maximum price range value, $\"]"))
				.sendKeys(dataTable.cell(1, 3));

		var searchForm = webDriver.findElements(By.tagName("form")).stream()
				.filter(f -> !"gh-f".equals(f.getAttribute("id"))).findFirst();
		if (searchForm.isPresent()) {
			searchForm.get().findElement(By.tagName("button")).click();
		}
	}
}
