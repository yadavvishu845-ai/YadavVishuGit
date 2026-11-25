package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.remote.AppiumWebElement;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


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
    }
    @Test
    public void dragAndDropTest1(){
        // creates a toggle for the given test, adds all log events under it
        ExtentTest test1 = extent.createTest("MyFirstTestOne", "Sample Test Demo");
        test1.log(Status.INFO,"Clicking on View Tab");
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
        test1.log(Status.INFO,"Clicking on Drag And Drop Tab");
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Drag and Drop']")).click();
        test1.log(Status.INFO,"Taking the Location Of Source");
        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        test1.log(Status.INFO,"Taking the Location Of Destination");
        WebElement target = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));


        test1.log(Status.INFO,"Getting the Id Of the Source for Mobile Gesture Command");
        String sourceId = ((AppiumWebElement) source).getId();

        test1.log(Status.INFO,"Method for getting exact center point of the target");
        Rectangle t = target.getRect();
        int startX = t.getX() + t.getWidth() / 2;
        int startY = t.getY() + t.getWidth() / 2;

        test1.log(Status.INFO,"Performing the Drag and  Drop Action");
        driver.executeScript("mobile: dragGesture", Map.of(
                "elementId", sourceId,
                "endX", startX + 150,
                "endY", startY,
                "speed", 500
        ));

        test1.log(Status.INFO,"Getting the text of Drop Action being Completed");
        String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result, "Dropped!");
        test1.log(Status.PASS,"Drag And Drop Test passed");
    }
}
