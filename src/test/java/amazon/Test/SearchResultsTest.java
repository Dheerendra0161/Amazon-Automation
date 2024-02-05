package amazon.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.Base.Amazon_Base;
import amzon.Pages.Home_Page;
import amzon.Pages.SearchResultsPage;
import amzon.Pages.SignInPage;
import amzon.Pages.SignIn_EmailOrMobilePage;
import amzon.Pages.SignIn_PasswordPage;

public class SearchResultsTest extends Amazon_Base {

	WebDriver driver;
	Home_Page homePage;
	SignInPage signIN;

	public SearchResultsTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = launchingBrowser("Chrome");
		homePage = new Home_Page(driver);

		SignIn_EmailOrMobilePage emailAndMob = homePage.click_On_SignIn();
		Assert.assertEquals(emailAndMob.publicPoicyNotice(),
				"By continuing, you agree to Amazon's Conditions of Use and Privacy Notice.", "Policy agree not found");
		SignIn_PasswordPage Password = emailAndMob.signInEmail();

		Assert.assertTrue(Password.forgotPass(), "Forgot your password? not present");

		SignInPage SigninPage = Password.signIn();
		Assert.assertTrue(SigninPage.VerfifyingUser(), "UserPage Not Found");

		signIN = new SignInPage(driver);

	}

	@AfterMethod
	public void tearDown() {
		if(driver!=null)
		driver.quit();
        driver.manage().deleteAllCookies();
	}

	@Test
	public void searchValidProduct() {
		SearchResultsPage searchResPage = signIN.searchProducBox("google pixel 8 pro");
		Assert.assertTrue(searchResPage.SearchProText(), "Search Product Not Found");
		searchResPage.clickOnSearchedProduct();

	}

}
