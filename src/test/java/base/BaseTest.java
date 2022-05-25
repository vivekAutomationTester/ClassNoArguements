package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import library.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {


    // Creating a report in the target folder.
    private ExtentSparkReporter htmlReporter;
    // Creating a report in the target folder.
    protected static ExtentReports extentReports;
    // `extentTestThread` is a thread local variable. It is used to store the test name.
    protected ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

    // `webdriver` is a thread local variable. It is used to store the webdriver instance.
    protected ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();

    @BeforeSuite
    // Creating a report in the target folder.
    public void intialise()
    {
        // Reporter - Specify the file to use
        htmlReporter = new ExtentSparkReporter(
                "target//reports//myReport.html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        extentReports.setSystemInfo("HostName", "Local Host");
        extentReports.setSystemInfo("OS", "Windows10");
        extentReports.setSystemInfo("TesterName", "Vivek");
        extentReports.setSystemInfo("Browser", "Chrome");


    }

    @BeforeMethod
    public void setUpBrowser()
    {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        webDriverFactory.setDriver();
        webdriver.set(webDriverFactory.getDriver());
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            extentTestThread.get().log(Status.FAIL, "Test Case Failed is " + result.getTestName());
            extentTestThread.get().log(Status.FAIL, "The error message: " + result.getThrowable());
            String screenshotPath = getScreenshot(webdriver, result.getName());
            extentTestThread.get().addScreenCaptureFromPath(screenshotPath);
        }

        if(result.getStatus() == ITestResult.SKIP)
            extentTestThread.get().log(Status.SKIP, "Test Skipped");

        if(result.getStatus() == ITestResult.SUCCESS)
            extentTestThread.get().log(Status.PASS, "Test Passed");

        extentReports.flush();
        webdriver.get().quit();
        webdriver.remove();
    }


    /**
     * @param testName
     */
    // `createTest` is creating a test in the report.
    public void createTest(String testName)
    {
        extentTestThread.set(extentReports.createTest(testName));

    }
    /*
     * Logging the message in the report.
     */
    public void assertAndLog(boolean condition, String textMessage)
    {
        extentTestThread.get().log(Status.PASS, "Verified that " + textMessage);
    }

    private String getScreenshot(ThreadLocal<WebDriver> webdriver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) webdriver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File fileDestination = new File(destination);
        FileUtils.copyFile(source, fileDestination);

        return destination;
    }

}
