package base;

import library.ReportManager;
import library.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
    protected ReportManager reportManager = new ReportManager();

    @BeforeSuite
    public void intialise()
    {

    }

    @BeforeMethod
    public void setUpBrowser()
    {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        webDriverFactory.setDriver();
        webdriver.set(webDriverFactory.getDriver());
    }

    @AfterMethod
    public void closeBrowser()
    {
        webdriver.get().quit();
    }

}
