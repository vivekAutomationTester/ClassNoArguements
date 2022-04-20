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

    public void maximize()
    {

    }

    public void minimize()
    {

    }

    public void refreshPage()
    {

    }

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

    public void pageToLoad()
    {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
