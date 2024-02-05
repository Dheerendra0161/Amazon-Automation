package amzon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_EmailOrMobilePage {

	WebDriver driver;
	
	@FindBy(xpath="//input[@id='ap_email']")	
	WebElement emailOrMobleNumber_Box;
	
	@FindBy(id="legalTextRow")	
	WebElement policyNotice;
	

	@FindBy(xpath="//input[@id='continue']")
	WebElement continueButton;
	
	
	
	public SignIn_EmailOrMobilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public SignIn_PasswordPage signInEmail() {
		
		emailOrMobleNumber_Box.click();
		emailOrMobleNumber_Box.sendKeys("8750170763");
		continueButton.click();
		return new SignIn_PasswordPage(driver);
	}

	
	public String publicPoicyNotice() {
		return policyNotice.getText();
		
	}
	


	
	
	
	
	
	
	
	
	
	

}
