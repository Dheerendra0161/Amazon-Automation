package amazon.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.Base.Amazon_Base;
import amzon.Pages.Home_Page;
import amzon.Pages.ProductDetailsPage;
import amzon.Pages.SignInPage;
import amzon.Pages.SignIn_EmailOrMobilePage;
import amzon.Pages.SignIn_PasswordPage;
import amzon.Utils.ActionsClass;

public class SignOutTest extends Amazon_Base {

    WebDriver driver;
    Home_Page homePage;
    SignInPage signIN;
    ProductDetailsPage proDetailsPage;
    ActionsClass actionsClass; // Add ActionsClass reference

    public SignOutTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        driver = launchingBrowser("Chrome");
        homePage = new Home_Page(driver);
        actionsClass = new ActionsClass(driver); // Initialize ActionsClass
    }

    @Test
    public void userSignOut() {
        signIN.signOut(); // Pass ActionsClass instance to signOut method
    }
}
