package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserActions {

    protected DriverObj driverObj;

    public UserActions(WebDriver driver, ReportManager reportManager)
    {
        this.driverObj = new DriverObj(driver, reportManager);
    }

    protected WaitHelper waitFor()
    {
        return new WaitHelper(driverObj.getDriver());
    }

    protected WebElement findElement(By by)
    {
        return driverObj.getDriver().findElement(by);
    }


    public void openUrl(String url) {
        driverObj.getDriver().get(url);
    }

    public void setText(WebElement webElement, String textValue) {
        waitFor().elementToBePresent(webElement);
        webElement.sendKeys(textValue);
        // report the operation
        String operation = "";
    }

    public void clickField(WebElement webElement) {
        waitFor().elementToBePresent(webElement);
        webElement.click();
        // report the operation
        String operation = "";
    }


    public void submit(WebElement webElement)
    {
        waitFor().elementToBePresent(webElement);
        webElement.submit();
    }


}
