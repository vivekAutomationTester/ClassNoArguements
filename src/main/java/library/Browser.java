package library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {

    private WebDriver driver;
    public Browser(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * Maximize() maximizes the window.
     */
    public void maximize()
    {

    }

    // Minimizing the browser window.
    public void minimize()
    {

    }

    // Refreshing the page.
    public void refreshPage()
    {

    }

    // Opening the URL.
    public void openUrl()
    {

    }

    public void scrollPage()
    {

    }

    public void resizeBrowser()
    {

    }

    public void minimizeWindow()
    {

    }

    public void navigateBack()
    {

    }

    public void navigateForward()
    {

    }

    /**
     * Wait for the page to load, and then return the page's readyState
     */
    public void pageToLoad()
    {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
