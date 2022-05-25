package library;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class BasePage extends UserActions{

    public BasePage(WebDriver driver, ExtentTest reportManager)
    {
        super(driver, reportManager);
    }




}
