package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("test@email.com", "password123");

        Assert.assertTrue(driver.getTitle().contains("Automation"));
    }
}
