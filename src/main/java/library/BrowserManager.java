package library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserManager {

    public WebDriver openBrowser(BrowserType browserType)
    {
        switch(browserType)
        {
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }


    }

    public ChromeOptions chromeOptions()
    {

        return null;
    }

    public void firefoxOptions()
    {

    }

    public void edgeOptions()
    {

    }


}
