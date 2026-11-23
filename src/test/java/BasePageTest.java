import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BasePageTest extends ExtentReport {

    static AndroidDriver driver;

    @BeforeTest
    public void setUp() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:automationName", "UiAutomator2");
        cap.setCapability("appium:platformVersion", "17");
        cap.setCapability("appium:deviceName", "Sachin Emulator");
         cap.setCapability("appium:app", "C:\\Users\\Sachin yadav\\Downloads\\ApiDemos-debug.apk");
        cap.setCapability("appium:newCommandTimeout", 60);
       // cap.setCapability("browserName", "Chrome");
       // cap.setCapability("appium:chromedriverAutodownload", "true");
        cap.setCapability("appium:udid", "emulator-5554");
        driver = new AndroidDriver(getUrl(), cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private URL getUrl() {
        try {
            return URI.create("http://127.0.0.1:4723/").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}