package amzon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']//span[contains(text(),'Google Pixel 8 Pro - Unlocked Android Smartphone with Telephoto Lens and Super Actua Display')]|//span[contains(text(),'Pixel 8 Pro - Unlocked Android Smartphone with Telephoto Lens and Super Actua Display - 24-Hour Battery - Porcelain - 128 GB')]")
	WebElement searchProductText;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement signInSubmit;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean SearchProText() {
		return searchProductText.isDisplayed();
	}

	public ProductDetailsPage clickOnSearchedProduct() {
		
		
		searchProductText.click();
		return new ProductDetailsPage(driver);
	}

}
