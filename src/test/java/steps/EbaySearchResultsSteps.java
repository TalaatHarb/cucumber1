package steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pages.SearchResultsPageActions;

@RequiredArgsConstructor
@Slf4j
public class EbaySearchResultsSteps {
	
	private final SearchResultsPageActions searchResultsPage;

	@Then("I confirm at least {int} results")
	public void iConfirmResultsCount(Integer minCount) {

		Integer result = searchResultsPage.getResultsCount();

		log.debug("Found {} result", result);

		assertTrue(result >= minCount);

		log.info("I confirm at least {} results", minCount.toString());
	}
}
