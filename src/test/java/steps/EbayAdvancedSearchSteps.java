package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		int size = dataTable.height();
		for (int i = 1; i < size; i++) {
			webDriver.findElement(By.xpath("//*[@id=\"_nkw\"]")).sendKeys(dataTable.cell(i, 0));
			webDriver.findElement(By.xpath("//*[@id=\"_ex_kw\"]")).sendKeys(dataTable.cell(i, 1));
			webDriver.findElement(By.cssSelector("[aria-label=\"Enter minimum price range value, $\"]"))
					.sendKeys(dataTable.cell(i, 2));
			webDriver.findElement(By.cssSelector("[aria-label=\"Enter maximum price range value, $\"]"))
					.sendKeys(dataTable.cell(i, 3));

			var searchForm = webDriver.findElements(By.tagName("form")).stream()
					.filter(f -> !"gh-f".equals(f.getAttribute("id"))).findFirst();
			if (searchForm.isPresent()) {
				searchForm.get().findElement(By.tagName("button")).click();
			}
		}
	}
}
