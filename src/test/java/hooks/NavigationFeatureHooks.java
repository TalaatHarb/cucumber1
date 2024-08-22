package hooks;

import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NavigationFeatureHooks {

	@Before(value = "@Navigation", order = 0)
	public void navigationScenariosSetup() {
		log.info("Navigation scenario");
	}
}
