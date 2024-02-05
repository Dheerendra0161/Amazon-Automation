package amzon.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amzon.Utils.ActionsClass;

public class SignInPage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='Hello, Dheerendra']")
	WebElement UserAccountVerification;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement signInSubmit;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchProductBox;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchSubmitButton;

	@FindBy(xpath = "//span[text()='Sign Out']")
	WebElement signOutButton;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean VerfifyingUser() {
		return UserAccountVerification.isDisplayed();
	}

	public SearchResultsPage searchProducBox(String searchProduct) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(searchProductBox));

		searchProductBox.click();
		searchProductBox.sendKeys(searchProduct);
		searchSubmitButton.click();
		return new SearchResultsPage(driver);
	}

	public void signOut() {
	
		ActionsClass.hoverOverElement(UserAccountVerification);
		signOutButton.click();

	}

}

