package test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login_standardUser() throws Exception {

        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();

        // Verify that the log in page is displayed
        assert(loginPage.verifyLoginPageDisplayed());
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);

        // Verify that the user is logged in
        assert(homePage.verifyUserIsLoggedIn());
        homePage.verifyUserIsLoggedIn();
        homePage.logout();

        // Verify that the user is logged out
        assert(loginPage.verifyLoginPageDisplayed());
        loginPage.verifyLoginPageDisplayed();

    }

    @Test
    public void login_lockedOutUser() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("locked_out_user", "secret_sauce");
        String errorMessage = loginPage.getErrorMessageDisplayed().trim();
        assert(errorMessage.contains("Sorry, this user has been locked out"));
    }

    @Test
    public void login_problem_user() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("problem_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();

    }

    @Test
    public void login_performanceGlitchUser() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("performance_glitch_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
    }

    @Test
    public void login_validUser() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();

    }



}
