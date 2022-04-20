package pages;

import library.BasePage;
import library.ReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver, ReportManager reportManager) {
        super(driver, reportManager);
    }

    public WebElement getMenuIcon()
    {
        return findElement(By.cssSelector("#react-burger-menu-btn"));
    }

    public void clickMenuIcon()
    {
        waitFor().pageToLoad();

        clickField(getMenuIcon());
    }

    public boolean verifyUserIsLoggedIn()
    {
        waitFor().pageToLoad();
        return getMenuIcon().isDisplayed();
    }


    public void logout()
    {
        clickMenuIcon();

        WebElement logoutLink = findElement(By.cssSelector("#logout_sidebar_link"));
        clickField(logoutLink);
    }

}
