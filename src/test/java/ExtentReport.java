import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtentReport {
    ExtentSparkReporter SparkReporter;
    ExtentReports extent;
    @BeforeSuite
    public void setup(){
        // start reporters
         SparkReporter = new ExtentSparkReporter("extent.html");

        // create ExtentReports and attach reporter(s)
        extent= new ExtentReports();
        extent.attachReporter(SparkReporter);
    }
    @AfterSuite
    public void teardown(){
        extent.flush();
    }
}
