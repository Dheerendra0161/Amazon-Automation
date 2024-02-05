package amzon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import amzon.Utils.ExplicitWait;

public class ProductDetailsPage {

	public WebDriver driver;
	WebElement ramSizeElement;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnRamSize(String ramSize) {

		String locator = "//p[contains(text(), '" + ramSize + "') and @class='a-text-left a-size-base']";
		WebElement ramSizeElement = driver.findElement(By.xpath(locator));
		ExplicitWait.waitForElementToBeClickable(ramSizeElement);

	}

	public boolean assertRamSizeSelected() {
		return ramSizeElement.isDisplayed();
	}

}
