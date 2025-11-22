package test2;


import test.BaseTest1;
import test.HomePage;
import test.LoginPage;
import test.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest1 
{
    @Test
    public void logoutAfterLogin() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("admin", "admin123");

        Assert.assertTrue(homePage.isLoaded(), "Home page did not load");

        LogoutPage logoutPage = homePage.logout();
        Assert.assertTrue(logoutPage.isAtLoginPage(), "Did not navigate back to login");
    }
}
