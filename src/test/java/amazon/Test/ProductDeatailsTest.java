package amazon.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.Base.Amazon_Base;
import amzon.Pages.Home_Page;
import amzon.Pages.ProductDetailsPage;
import amzon.Pages.SearchResultsPage;
import amzon.Pages.SignInPage;
import amzon.Pages.SignIn_EmailOrMobilePage;
import amzon.Pages.SignIn_PasswordPage;
import amzon.Utils.ExplicitWait;
import amzon.Utils.Utilities;

public class ProductDeatailsTest extends Amazon_Base {

	WebDriver driver;
	Home_Page homePage;
	SignInPage signIN;
	ProductDetailsPage proDetailsPage;

	public ProductDeatailsTest() {
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
		SearchResultsPage searchResPage = signIN.searchProducBox("google pixel 8 pro");
		Assert.assertTrue(searchResPage.SearchProText(), "Search Product Not Found");
		proDetailsPage = searchResPage.clickOnSearchedProduct();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(dataProvider = "RamDataSupplier")
	public void verifySearchedProduct(String Ramsize) {

		proDetailsPage.clickOnRamSize(Ramsize);
		Assert.assertTrue(proDetailsPage.assertRamSizeSelected(), "Requied ram size is not selected");
		signIN.signOut();
	}

	@DataProvider(name = "RamDataSupplier")
	public Object[][] SelectRamSizeTestData() {
		Object[][] data = null;
		try {
			data = Utilities.readDataFromExcel("RamSize");
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

}
