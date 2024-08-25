package steps;

import dto.CustomSearchDataDTO;
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
	public void iDoAdvancedSearch(CustomSearchDataDTO searchData) {
		advancedSearchPage.enterSearchTerm(searchData.getKeyword());
		advancedSearchPage.enterExcludeTerm(searchData.getExclude());
		advancedSearchPage.enterMinimumPrice(searchData.getMinPrice());
		advancedSearchPage.enterMaximumPrice(searchData.getMaxPrice());
		advancedSearchPage.clickSearchButton();
		
		log.info("I do advanced search");
	}
}
