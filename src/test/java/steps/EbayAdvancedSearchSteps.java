package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pages.AdvancedSearchPageActions;

@RequiredArgsConstructor
@Slf4j
public class EbayAdvancedSearchSteps {
	
	private final AdvancedSearchPageActions advancedSearchPage;

	@When("I click on Ebay logo")
	public void iClickOnEbayLogo() {
		advancedSearchPage.clickOnEbayLogo();
		log.info("I click on Ebay logo");
	}

	@When("I do advanced search")
	public void iDoAdvancedSearch(DataTable dataTable) {
		advancedSearchPage.enterSearchTerm(dataTable.cell(1, 0));
		advancedSearchPage.enterExcludeTerm(dataTable.cell(1, 1));
		advancedSearchPage.enterMinimumPrice(dataTable.cell(1, 2));
		advancedSearchPage.enterMaximumPrice(dataTable.cell(1, 3));
		advancedSearchPage.clickSearchButton();
		
		log.info("I do advanced search");
	}
}
