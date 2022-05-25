package library;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserActions {

    // A variable that is used to store the driver object.
    protected WebDriver driver;
    // A variable that is used to store the reportManager object.
    protected ExtentTest reportManager;



    public UserActions(WebDriver driver, ExtentTest reportManager)
    {
        this.driver = driver;
        this.reportManager = reportManager;
    }



    /**
     * > The function returns a new instance of the WaitHelper class, which is initialized with the driver object
     *
     * @return A new instance of the WaitHelper class.
     */
    protected WaitHelper waitFor()
    {
        return new WaitHelper(driver);
    }

    /**
     * It returns a WebElement object that matches the given By object
     *
     * @param by The By locator used to find the element.
     * @return The WebElement object that matches the given selector.
     */
    protected WebElement findElement(By by)
    {
        return driver.findElement(by);
    }

    /**
     * > Open a URL and wait for the page to load
     *
     * @param url The url to open
     */
    protected void openUrl(String url) {
        waitFor().pageToLoad();
        driver.get(url);
        waitFor().pageToLoad();
        logpass(String.format("Open Url: %s", url) );
      }

    /**
     * It logs a message with the status of PASS.
     *
     * @param textValue The text that you want to log in the report.
     */
    protected void logpass(String textValue)
    {
        reportManager.log(Status.PASS,textValue);
    }

    /**
     * It logs a message to the report.
     *
     * @param textValue The text that you want to log in the report.
     */
    public void logFail(String textValue)
    {
        reportManager.log(Status.PASS, textValue);
    }

    /**
     * Wait for the element to be present, then enter the text value into the field.
     *
     * @param webElement The web element you want to interact with.
     * @param fieldDescription This is the name of the field that you are entering text into.
     * @param textValue The text you want to enter into the field
     */
    public void setText(WebElement webElement, String fieldDescription, String textValue) {
        waitFor().elementToBePresent(webElement);
        webElement.sendKeys(textValue);
        logpass(String.format("Enter %s in the %s", textValue, fieldDescription));
    }


    /**
     * Click on the web element and report the operation.
     *
     * @param webElement The web element to be clicked
     * @param fieldDescription This is the description of the field that you want to click.
     */
    public void clickField(WebElement webElement, String fieldDescription) {
        waitFor().elementToBePresent(webElement);
        webElement.click();
        // report the operation
        logpass(String.format("Click on the %s", fieldDescription));
    }




}
