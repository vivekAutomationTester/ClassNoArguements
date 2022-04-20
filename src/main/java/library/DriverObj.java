package library;

import org.openqa.selenium.WebDriver;

public class DriverObj {

    private WebDriver driver;
    private ReportManager reportManager;

    public DriverObj(WebDriver driver, ReportManager reportManager) {
        this.driver = driver;
        this.reportManager = reportManager;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public ReportManager getReportManager() {
        return reportManager;
    }

    public void setReportManager(ReportManager reportManager) {
        this.reportManager = reportManager;
    }
}
