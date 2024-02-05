package amzon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_PasswordPage {
	
	

WebDriver driver;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement passWordBox;
	
	@FindBy(xpath="//a[@id='auth-fpp-link-bottom']")
	WebElement forgotPassOption;

	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signInSubmitButton;
	
	
	
	
	
	
	public SignIn_PasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public SignInPage signIn() {
		
		passWordBox.click();
		passWordBox.sendKeys("12344321");
		signInSubmitButton.click();
		return new SignInPage(driver);

	}
	
	
	public boolean forgotPass() {
		boolean forgotIsDisplayed = forgotPassOption.isDisplayed();
		return forgotIsDisplayed;
	}











}
