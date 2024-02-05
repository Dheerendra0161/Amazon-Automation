package amzon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amzon.Utils.ExplicitWait;

public class Home_Page {

	WebDriver driver;

	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement accountAndList;

	@FindBy(xpath = "//input[@data-action-type=\"DISMISS\"]")
	WebElement dissmissButtons;

	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public SignIn_EmailOrMobilePage click_On_SignIn() {
		//performActionIfDismissButtonPresent();

		accountAndList.click();
		return new SignIn_EmailOrMobilePage(driver);

	}

//	public void performActionIfDismissButtonPresent() {
//		if (dissmissButtons.isDisplayed()) {
//			ExplicitWait.waitForElementToBeClickable(dissmissButtons);
//			dissmissButtons.click(); // Click the first element if present
//		} else {
//			System.out.println("Dismiss button not found.");
//		}
//
//	}

}
