package pages.locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElementsLocator {

	@FindBy(xpath = "//*[@id=\"gh-ac\"]")
	public WebElement searchBox;

	@FindBy(xpath = "//*[@id=\"gh-btn\"]")
	public WebElement searchButton;

	@FindBy(xpath = "//*[@id=\"gh-cat\"]")
	public WebElement categoriesMenu;

	@FindBy(xpath = "//*[@id=\"gh-cat\"]/option")
	public List<WebElement> categories;

	public HomePageElementsLocator(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
}
