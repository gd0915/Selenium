package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import utilities.TestBase;

public class Day07_Alerts extends TestBase {
    /*
    Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
    Create a class: AlertTest
    Create setUp method
    Create 3 test methods:
    acceptAlert() => click on the first alert,
    verify the text “I am a JS Alert” ,
    click OK ,
    and Verify “You successfully clicked an alert”
    dismissAlert()=> click on the second alert,
    verify text "I am a JS Confirm”,
    click cancel,
    and Verify “You clicked: Cancel”
    sendKeysAlert()=> click on the third alert,
    verify text “I am a JS prompt”,
    type “Hello World”,
    click OK,
    and Verify “You entered: Hello World”
     */
    @Test
    public void  acceptAlert() throws InterruptedException {
      //acceptAlert() => click on the first alert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);
      //verify the text “I am a JS Alert”
        String actualAlertText = driver.switchTo().alert().getText();//get text
        Assert.assertEquals("I am a JS Alert", actualAlertText);

     //click OK
        driver.switchTo().alert().accept();//click ok
        Thread.sleep(2000);
     // and Verify “You successfully clicked an alert”
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert", actualResult);

    }

    @Test
    public void dismissAlert(){
        //dismissAlert()=> click on the second alert,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath(" //button[@onclick='jsConfirm()']")).click();

        // verify text "I am a JS Confirm”,
        String actualAlertText = driver.switchTo().alert().getText();//get text
        Assert.assertEquals("I am a JS Confirm", actualAlertText);

        //click OK
        driver.switchTo().alert().dismiss();

        //  and Verify “You clicked: Cancel”
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel", actualResult);
    }

    @Test
    public void sendKeysAlert(){
        //sendKeysAlert()=> click on the third alert,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath(" //button[@onclick='jsPrompt()']")).click();

        //verify text “I am a JS prompt”,
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt", actualAlertText);

        //type “Hello World”
       driver.switchTo().alert().sendKeys("Hello World");

       // click OK,
       driver.switchTo().alert().accept();

       //  and Verify “You entered: Hello World”
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World", actualResult);

    }

}
