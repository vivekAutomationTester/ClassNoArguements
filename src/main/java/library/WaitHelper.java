package library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private  WebDriver driver;

    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(30) );
    }

    public void elementToBePresent(WebElement webElement)
    {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void elementToBeNotPresent(WebElement webElement)
    {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void elementToContainText(WebElement webElement, String textValue)
    {
        wait.until(ExpectedConditions.textToBePresentInElementValue(webElement, textValue));
    }

    public void pageToLoad()
    {
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }


}
