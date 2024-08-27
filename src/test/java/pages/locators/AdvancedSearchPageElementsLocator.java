package pages.locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPageElementsLocator {

	@FindBy(xpath = "//*[@id='gh-logo']")
	public WebElement ebayLogo;

	@FindBy(xpath = "//*[@id=\"_nkw\"]")
	public WebElement searchInputBox;

	@FindBy(xpath = "//*[@id=\"_ex_kw\"]")
	public WebElement excludeInputBox;

	@FindBy(css = "[aria-label=\"Enter minimum price range value, $\"]")
	public WebElement minPriceBox;

	@FindBy(css = "[aria-label=\"Enter maximum price range value, $\"]")
	public WebElement maxPriceBox;

	@FindBy(tagName = "form")
	public List<WebElement> forms;

	@FindBy(xpath = "//div[@class='adv-form__actions']//button[@type='submit'][normalize-space()='Search']")
	public WebElement searchButton;

	public AdvancedSearchPageElementsLocator(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
}
