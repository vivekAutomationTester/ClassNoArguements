package library;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class DriverObj {

    private WebDriver driver;
    private ExtentTest reportManager;

    public DriverObj(WebDriver driver, ExtentTest reportManager) {
        this.driver = driver;
        this.reportManager = reportManager;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public ExtentTest getReportManager() {
        return reportManager;
    }

    public void setReportManager(ExtentTest reportManager) {
        this.reportManager = reportManager;
    }
}
