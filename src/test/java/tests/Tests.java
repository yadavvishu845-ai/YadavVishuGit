package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


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
    }
}
