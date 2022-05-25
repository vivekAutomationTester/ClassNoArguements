package pages;

import com.aventstack.extentreports.ExtentTest;
import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, ExtentTest reportManager) {
        super(driver, reportManager);
    }

    public void openPage()
    {
        openUrl("https://www.saucedemo.com/");
    }

    public void login(String username, String password)
    {
        waitFor().pageToLoad();
        WebElement usernameTextBox = findElement(By.cssSelector("#user-name"));
        setText(usernameTextBox, "Username Textbox", username);

        WebElement passwordTextBox = findElement(By.cssSelector("#password"));
        setText(passwordTextBox,"Password Textbox", password);

        WebElement loginButton = findElement(By.cssSelector("#login-button"));
        clickField(loginButton, "Login Button");
    }

    public boolean verifyLoginPageDisplayed()
    {
        waitFor().pageToLoad();
        WebElement logoPicture = findElement(By.cssSelector(".bot_column"));
        waitFor().elementToBePresent(logoPicture);
        return logoPicture.isDisplayed();
    }

    public String getErrorMessageDisplayed()
    {
        verifyLoginPageDisplayed();
        WebElement errorMessage = findElement(By.cssSelector(".error-message-container.error"));
        waitFor().elementToBePresent(errorMessage);
        return errorMessage.getText().trim();

    }



}
