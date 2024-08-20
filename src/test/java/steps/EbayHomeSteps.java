package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EbayHomeSteps {

	private static final long IMPLICIT_WAIT = 60L;
	private static final String HOME_PAGE_URL = "https://www.ebay.com/";
	private static final String ADVANCED_SEARCH_PAGE_URL = "https://www.ebay.com/sch/ebayadvsearch";
	private static final List<String> CHROME_ARGUMENTS = List.of("ignore-certificate-errors", "disable-extensions",
			"window-size=1920,1080", "no-sandbox", "disable-dev-shm-usage");

	private static final List<String> HEADLESS_CHROME_ARGUMENTS = List.of("headless", "disable-gpu",
			"remote-debugging-port=9222");

	private WebDriver webDriver;

	@Given("I am on Ebay Home page")
	public void iAmOnEbayHomePage() {
		createWebDriver();

		webDriver.get(HOME_PAGE_URL);

		log.info("I am on Ebay Home page");
	}

	private void createWebDriver() {
		final ChromeDriverService service = (new ChromeDriverService.Builder()).build();
		final ChromeOptions options = new ChromeOptions();
		options.addArguments(CHROME_ARGUMENTS);

		String os = System.getProperty("os.name");
		log.info("OS: {}", os);
		if (!os.contains("Windows")) {
			options.addArguments(HEADLESS_CHROME_ARGUMENTS);
		}

		webDriver = new ChromeDriver(service, options);
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		webDriver.manage().window().maximize();
	}

	@When("I click on Advanced Link")
	public void iClickOnAdvancedLink() {
		webDriver.findElement(By.linkText("Advanced")).click();
		log.info("I click on Advanced Link");
	}

	@Then("I naviagate to the Advanced Search page")
	public void iNaviagateToTheAdvancedSearchPage() {
		String currentURL = webDriver.getCurrentUrl();
		assertEquals(ADVANCED_SEARCH_PAGE_URL, currentURL);
		webDriver.close();
		log.info("I naviagate to the Advanced Search page");
	}
}
