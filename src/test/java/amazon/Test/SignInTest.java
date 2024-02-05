package amazon.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import amazon.Base.Amazon_Base;
import amzon.Pages.Home_Page;
import amzon.Pages.SignInPage;
import amzon.Pages.SignIn_EmailOrMobilePage;
import amzon.Pages.SignIn_PasswordPage;

public class SignInTest extends Amazon_Base {

	WebDriver driver;
	Home_Page homePage;

	public SignInTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = launchingBrowser("Chrome");
		homePage = new Home_Page(driver);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
    @Test
	public void signIn_With_ValidCredential() {

		SignIn_EmailOrMobilePage emailAndMob = homePage.click_On_SignIn();
		Assert.assertEquals(emailAndMob.publicPoicyNotice(),"By continuing, you agree to Amazon's Conditions of Use and Privacy Notice.","Policy agree not found");
		SignIn_PasswordPage Password = emailAndMob.signInEmail();
		
		Assert.assertTrue(Password.forgotPass(), "Forgot your password? not present");
		
		SignInPage SigninPage = Password.signIn();
		Assert.assertTrue(SigninPage.VerfifyingUser(), "UserPage Not Found");
		

	}

}
