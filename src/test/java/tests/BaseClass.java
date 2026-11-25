package tests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class BaseClass extends ExtentReportsDemo {


    static  AppiumDriver driver;

    @BeforeMethod
    public void setup() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "17");
            caps.setCapability("appium:deviceName", "Vishu Emulator");
            caps.setCapability("appium:udid", "emulator-5554");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:newCommandTimeout", 60);
            caps.setCapability("appium:app", "C:/Users/ASUS/Downloads/ApiDemos-debug (1).apk");
            //caps.setCapability("browserName", "Chrome");
            //caps.setCapability("appium:chromedriverAutodownload", true);

            URL url = new URL("http://127.0.0.1:4723/");

            driver = new AppiumDriver(url,caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
            System.out.println("Application Started .....");


        } catch (Exception exp) {
            System.out.println("Cause is : " + exp.getCause());
            System.out.println("Message is :" + exp.getMessage());
            exp.printStackTrace();
        }
    }


    @AfterMethod
    public void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
