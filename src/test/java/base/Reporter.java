package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;

public class Reporter {

    // Create the HTML file
    public ExtentSparkReporter htmlReporter;

    public ExtentReports extent;

    public ExtentTest extentTest;

    @BeforeTest
    public void setReporter()
    {
        htmlReporter = new ExtentSparkReporter("./reports/extent.html");
        
    }
}
