package pages.locators;

import java.util.List;

import org.openqa.selenium.By;
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

	public WebElement searchButton;

	public AdvancedSearchPageElementsLocator(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);

		searchButton = findSearchButton();
	}

	private WebElement findSearchButton() {
		var searchForm = forms.stream().filter(f -> !"gh-f".equals(f.getAttribute("id"))).findFirst();
		if (searchForm.isPresent()) {
			return searchForm.get().findElement(By.tagName("button"));
		} else {
			return null;
		}
	}

}
