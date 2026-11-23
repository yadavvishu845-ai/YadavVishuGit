package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtentReportsDemo {

    ExtentSparkReporter sparkReporter;
    ExtentReports extent;

    @BeforeSuite
    public void reportSetup() {
        sparkReporter = new ExtentSparkReporter("target/extent.html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void reportTearDown() {
        // calling flush writes everything to the log file
        extent.flush();
    }
}
