package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test10_Synchronization extends TestBase {
    /*
    Create a class:Synchronization3. Create a method: synchronization1
    Go to https://the-internet.herokuapp.com/dynamic_controls
    Click on remove button
    And verify the message is equal to “It's gone!”
    Then click on Add button
    And verify the message is equal to “It's back!”
     */

    @Test
    public void synchronizationTest(){
        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click on remove button
        driver.findElement(By.xpath("//form[@id='checkbox-example']//button")).click();

        // Then verify the message is equal to “It's gone!”
        WebElement message1 = waitForVisibility(driver.findElement(By.id("message")), 5);
        Assert.assertEquals("It's gone!", message1.getText());

        // Then click on Add button
        driver.findElement(By.xpath("//form[@id='checkbox-example']//button")).click();

        // And verify the message is equal to “It's back!”
        WebElement message2 = waitForVisibility(driver.findElement(By.id("message")), 5);
        Assert.assertEquals("It's back!", message2.getText());


    }
}
