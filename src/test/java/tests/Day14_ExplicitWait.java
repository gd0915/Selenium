package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Day14_ExplicitWait extends TestBase {
    /*
    Create a class:ExplicitWait
    Create a method: explicitWait
    Go to https://the-internet.herokuapp.com/dynamic_loading/1
    When user clicks on the Start button
    Then verify the ‘Hello World!’ Shows up on the screen
     */

    @Test
    public void explicitWaitTest(){

        //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        //Then verify the ‘Hello World!’ Shows up on the screen
        //THIS PIECE OF CODE FAILS CAUSE IMPLICIT WAIT IS NOT ABLE TO HANDLE THE ELEMENT
        //SOLUTION : TRY EXPLICIT WAIT OR FLUENT WAIT
//        WebElement helloElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
//        Assert.assertEquals("Hello World!", helloElement.getText());

        // 1. Create WebDriver Wait Object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // accepts 2 parameters 1.driver and 2. how long do you want to wait
                                                                                // It is coming from Selenium

        // 2. Use wait to handle synchronization issue(wait issue)
        // * waits for the xpath to be visible up to 10 seconds
        // * returns the WEB ELEMENT
        // * if the element is not found within 10 seconds, then throws TIME OUT EXCEPTION
        WebElement helloElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals("Hello World!", helloElement.getText());
    }

    @Test
    public void explicitWaitReusable(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        WebElement helloElement = waitForClickablility(By.xpath("//div[@id='finish']//h4"), 10);
        Assert.assertEquals("Hello World!", helloElement.getText());

    }



}
/*
Explicit wait is stronger than implicit wait
 */