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
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
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

    @Test
    public void login_standardUser1() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
    }

    @Test
    public void login_lockedOutUser1() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("locked_out_user", "secret_sauce");
        String errorMessage = loginPage.getErrorMessageDisplayed().trim();
        assert(errorMessage.contains("Sorry, this user has been locked out"));
    }

    @Test
    public void login_problem_user1() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("problem_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();

    }

    @Test
    public void login_performanceGlitchUser1() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("performance_glitch_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
    }

    @Test
    public void login_validUser1() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();

    }

    @Test
    public void login_standardUser2() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
    }

    @Test
    public void login_lockedOutUser2() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("locked_out_user", "secret_sauce");
        String errorMessage = loginPage.getErrorMessageDisplayed().trim();
        assert(errorMessage.contains("Sorry, this user has been locked out"));
    }

    @Test
    public void login_problem_user2() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("problem_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();

    }

    @Test
    public void login_performanceGlitchUser2() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("performance_glitch_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
    }

    @Test
    public void login_validUser2() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();

    }

    @Test
    public void login_standardUser3() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
    }

    @Test
    public void login_lockedOutUser3() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("locked_out_user", "secret_sauce");
        String errorMessage = loginPage.getErrorMessageDisplayed().trim();
        assert(errorMessage.contains("Sorry, this user has been locked out"));
    }

    @Test
    public void login_problem_user3() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("problem_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();

    }

    @Test
    public void login_performanceGlitchUser3() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("performance_glitch_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
    }

    @Test
    public void login_validUser3() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();

    }

    @Test
    public void login_standardUser4() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
    }

    @Test
    public void login_lockedOutUser4() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("locked_out_user", "secret_sauce");
        String errorMessage = loginPage.getErrorMessageDisplayed().trim();
        assert(errorMessage.contains("Sorry, this user has been locked out"));
    }

    @Test
    public void login_problem_user4() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("problem_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();

    }

    @Test
    public void login_performanceGlitchUser4() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("performance_glitch_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();
    }

    @Test
    public void login_validUser4() throws Exception {
        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(webdriver.get(), reportManager);
        homePage.verifyUserIsLoggedIn();
        homePage.logout();
        loginPage.verifyLoginPageDisplayed();

    }


}
