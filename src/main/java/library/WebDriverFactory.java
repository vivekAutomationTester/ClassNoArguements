package library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private WebDriver driver;

    public void setDriver()
    {
        setDriver(BrowserType.CHROME);
    }

    public void setDriver(BrowserType browserType)
    {
        driver = new BrowserManager().openBrowser(BrowserType.CHROME);
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
