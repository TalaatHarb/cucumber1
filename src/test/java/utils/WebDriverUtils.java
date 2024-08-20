package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebDriverUtils {

	public static final List<String> HEADLESS_CHROME_ARGUMENTS = List.of("headless", "disable-gpu",
	"remote-debugging-port=9222");
	public static final long IMPLICIT_WAIT = 10L;
	public static final List<String> CHROME_ARGUMENTS = List.of("ignore-certificate-errors", "disable-extensions",
	"window-size=1920,1080", "no-sandbox", "disable-dev-shm-usage");
	public static final WebDriver createWebDriver() {
		final ChromeDriverService service = (new ChromeDriverService.Builder()).build();
		final ChromeOptions options = new ChromeOptions();
		options.addArguments(CHROME_ARGUMENTS);
	
		String os = System.getProperty("os.name");
		log.debug("OS: {}", os);
		if (!os.contains("Windows")) {
			options.addArguments(HEADLESS_CHROME_ARGUMENTS);
		}
	
		ChromeDriver chromeDriver = new ChromeDriver(service, options);
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		chromeDriver.manage().window().maximize();
		
		return chromeDriver;
	}

}
