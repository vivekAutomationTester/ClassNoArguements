package library;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
 *
 * Driver class is responsible for invoking and closing the browsers.
 *
 * <p>
 * It is also responsible for
 * setting the driver variable to DriverManager which handles the thread safety for the
 * webdriver instance.
 *
 * <pre>
 * <b>
 * <a href="https://www.youtube.com/channel/UC6PTXUHb6j4Oxf0ccdRI11A">Testing Mini Bytes Youtube channel</a>
 * </b>
 * </pre>
 *
 * Jan 20, 2021
 * @author Vivek Kannapiran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 */

public final class Driver {

    /**
     * Private constructor to avoid external instantiation
     */
    private Driver() {}

    /**
     * Gets the browser value and initialise the browser based on that
     *
     * @author Amuthan Sakthivel
     * Jan 20, 2021
     *
     */
    public static void initDriver(String browser,String version)  {


        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser,version));

            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Please check the capabilities of browser");
            }
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    /**
     * Terminates the browser instance.
     * Sets the threadlocal to default value, i.e null.
     * @author Amuthan Sakthivel
     * Jan 22, 2021
     */
    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }