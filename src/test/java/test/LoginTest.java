package test;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login_standardUser() throws Exception {

            createTest("Login as Standard User");

            LoginPage loginPage = new LoginPage(webdriver.get(), extentTestThread.get());
            loginPage.openPage();

            // Verify that the log in page is displayed
            assertAndLog (loginPage.verifyLoginPageDisplayed(),"Login Page is displayed");
            loginPage.login("standard_user", "secret_sauce");

            // Verify that the user is logged in
            HomePage homePage = new HomePage(webdriver.get(), extentTestThread.get());
            assertAndLog (homePage.verifyUserIsLoggedIn(),"User is logged into the application");

            // Log out
            homePage.logout();

            // Verify that the user is logged out
            assertAndLog (loginPage.verifyLoginPageDisplayed(), "User is logged out");
    }

    @Test
    public void login_lockedOutUser() throws Exception {

        createTest("Login as locked out user");
        LoginPage loginPage = new LoginPage(webdriver.get(), extentTestThread.get());
        loginPage.openPage();

        loginPage.login("locked_out_user", "secret_sauce");

        String errorMessage = loginPage.getErrorMessageDisplayed().trim();
        assertAndLog(errorMessage.contains("Sorry, this user has been locked out"), "Error message is displayed");
    }

    @Test
    public void login_problem_user() throws Exception {
        createTest("Login as Problem User");
        LoginPage loginPage = new LoginPage(webdriver.get(), extentTestThread.get());
        loginPage.openPage();
        loginPage.login("problem_user", "secret_sauce");

        HomePage homePage = new HomePage(webdriver.get(), extentTestThread.get());
        assertAndLog(homePage.verifyUserIsLoggedIn(), "user is logged in");
        homePage.verifyUserIsLoggedIn();

        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
        assertAndLog (loginPage.verifyLoginPageDisplayed(), "User is logged out");
    }

    @Test
    public void login_performanceGlitchUser() throws Exception {

        createTest("Login as Performance Glitch User");
        LoginPage loginPage = new LoginPage(webdriver.get(), extentTestThread.get());
        loginPage.openPage();
        loginPage.login("performance_glitch_user", "secret_sauce");

        HomePage homePage = new HomePage(webdriver.get(), extentTestThread.get());
        assertAndLog(homePage.verifyUserIsLoggedIn(), "user is logged in");
        homePage.verifyUserIsLoggedIn();

        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
        assertAndLog (loginPage.verifyLoginPageDisplayed(), "User is logged out");
    }

    @Test
    public void login_validUser() throws Exception {

        createTest("Login as Valid User");
        LoginPage loginPage = new LoginPage(webdriver.get(), extentTestThread.get());
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(webdriver.get(), extentTestThread.get());
        assertAndLog(homePage.verifyUserIsLoggedIn(), "user is logged in");
        homePage.verifyUserIsLoggedIn();

        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
        assertAndLog (loginPage.verifyLoginPageDisplayed(), "User is logged out");
    }



}
