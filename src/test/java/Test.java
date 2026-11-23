import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static org.testng.AssertJUnit.fail;

public class Test extends BasePageTest  {


//    @org.testng.annotations.Test
//    public void testUntitledTestCase() throws Exception {
//        ExtentTest test1 = extent.createTest("MyFirstTest", "Sample description");
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//        // driver.get("https://www.google.com/search?q=orangehrm+login&oq=orangehrm+lo&gs_lcrp=EgZjaHJvbWUqBwgAEAAYgAQyBwgAEAAYgAQyBwgBEAAYgAQyBggCEEUYOTIHCAMQABiABDIHCAQQABiABDIHCAUQABiABDIHCAYQABiABDIHCAcQABiABDIHCAgQABiABDIICAkQABgWGB7SAQk2Nzk4ajBqMTWoAgiwAgE&sourceid=chrome&source=chrome.rb&ie=UTF-8");
//        // driver.findElement(By.id("_iJ4Ca-CcEcD34-EP_rX06Q0_70")).click();
//        driver.get("https://practice.expandtesting.com/drag-and-drop");
//        test1.pass("Opned OrangeHRM");
//        driver.findElement(By.name("username")).click();
//        driver.findElement(By.name("username")).clear();
//        driver.findElement(By.name("username")).sendKeys("Admin");
//        test1.pass("Entered  Username");
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("password")).clear();
//        driver.findElement(By.name("password")).sendKeys("admin123");
//        test1.pass("Entered  Password");
//        // wait.until(ExpectedConditions.elementToBeClickable(
//        //   By.xpath("//div[.=' Login ']"))).click();
//        driver.findElement(By.xpath("//div[.=' Login ']")).click();
//        test1.pass("Sucessfully Clicked  login Button");
//        // Thread.sleep(20000);
//        driver.findElement(By.xpath("//div[@id='app']/div/div/header/div/div[3]/ul/li/span")).click();
//        //wait.until(ExpectedConditions.urlContains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
//        //WebElement userMenu = wait.until(ExpectedConditions.elementToBeClickable(
//        //By.cssSelector(".oxd-userdropdown-tab")));
//        //Thread.sleep(2000);
//        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='app']/div/div/header/div/div[3]/ul/li/span"))).click();
//        driver.findElement(By.linkText("Logout")).click();
//        test1.pass("Sucessfully Clicked  logged out ");
//        // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    }
    @org.testng.annotations.Test
    public void DragDrop(){
       // driver.get("https://practice.expandtesting.com/drag-and-drop");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement colA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='column-b']")));
            JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");


        Actions builder = new Actions(driver);
            WebElement from = driver.findElement(By.id("column-b"));
            WebElement to = driver.findElement(By.id("column-a"));
            builder.dragAndDrop(from, to).build().perform();


            Actions builder1 = new Actions(driver);
            WebElement from1 = driver.findElement(By.xpath("//*[@id='column-b']"));
            WebElement to1 = driver.findElement(By.xpath("//*[@id='column-a']"));
            builder.dragAndDrop(from1, to1).build().perform();

        By headerA = By.cssSelector("#column-a header");
        By headerB = By.cssSelector("#column-b header");
        // After drag: wait for the swap, then assert
        wait.until(ExpectedConditions.textToBe(headerA, "B"));
        Assert.assertEquals(driver.findElement(headerA).getText().trim(), "B", "Column A should now show B");
        Assert.assertEquals(driver.findElement(headerB).getText().trim(), "A", "Column B should now show A");

    }

    }

