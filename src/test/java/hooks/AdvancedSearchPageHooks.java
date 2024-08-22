package hooks;

import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdvancedSearchPageHooks {

	@Before(value = "@AdvancedSearch", order = 1)
	public void advancedSearchPageScenariosSetup() {
		log.info("Advanced search Page scenario");
	}
}
