package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Tests extends BaseClass{

    @Test
    public void testOne(){

        // creates a toggle for the given test, adds all log events under it
        ExtentTest test1 = extent.createTest("MyFirstTestOne", "Sample Test Demo");
        // log(Status, details)
        test1.log(Status.INFO, "This step shows the details of test step");
        driver.get("https://www.google.com/");
        test1.log(Status.PASS, "Navigation to https://www.google.com/ ");
        driver.findElement(By.name("q")).sendKeys("Automation");
        test1.log(Status.PASS, "Entering Automation in the Search Field");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.println("Completed Test One ....");
        test1.log(Status.INFO, "Test One Completed");
    }

    @Test
    public void testTwo(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Vishu");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.println("Completed Test Two ....");
    }

    @Test
    public void loginTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        driver.findElement(By.xpath("//div[@id='app']/div/div/header/div/div[3]/ul/li/span")).click();
        driver.findElement(By.linkText("Logout")).click();
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    } @org.testng.annotations.Test
    public void DragDrop(){
        // driver.get("https://practice.expandtesting.com/drag-and-drop");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement colA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='column-b']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");


        Actions builder = new Actions(driver);
//            WebElement from = driver.findElement(By.id("column-b"));
//            WebElement to = driver.findElement(By.id("column-a"));
//            builder.dragAndDrop(from, to).build().perform();


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
