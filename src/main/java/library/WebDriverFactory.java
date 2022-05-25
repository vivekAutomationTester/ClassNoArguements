package library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    // A variable that is used to store the instance of the browser.
    private WebDriver driver;

    // Setting the driver to a new instance of the BrowserManager class.
    public void setDriver()
    {
        setDriver(BrowserType.CHROME);
    }

    /**
     * It opens a browser and maximizes it.
     *
     * @param browserType The type of browser you want to use.
     */
    public void setDriver(BrowserType browserType)
    {
        driver = new BrowserManager().openBrowser(BrowserType.CHROME);
        driver.manage().window().maximize();
    }

    // Returning the driver.
    public WebDriver getDriver()
    {
        return driver;
    }
}
