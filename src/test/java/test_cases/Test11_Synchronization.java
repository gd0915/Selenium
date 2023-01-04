package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test11_Synchronization extends TestBase {
    /*
        Create a class:Synchronization4. Create a method: isEnabled
        Go to https://the-internet.herokuapp.com/dynamic_controls
        Click enable Button
        And verify the message is equal to “It's enabled!”
        And verify the textbox is enabled (I can type in the box)
        And click on Disable button
        And verify the message is equal to “It's disabled!”
        And verify the textbox is disabled (I cannot type in the box)
        NOTE: .isEnabled(); is used to check if an element is enabled or not
     */
    @Test
    public void isEnabledTest(){
        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click enable Button
        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();

        //Verify the message is equal to “It's enabled!”
        WebElement message1 = waitForVisibility(driver.findElement(By.id("message")), 5);
        Assert.assertEquals("It's enabled!", message1.getText());

        //Verify the textbox is enabled (I can type in the box)
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='input-example']//input")).isEnabled());

        //Click on Disable button
        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();

        //verify the message is equal to “It's disabled!”
        WebElement message2 = waitForVisibility(driver.findElement(By.id("message")), 5);
        Assert.assertEquals("It's disabled!", message2.getText());

        //And verify the textbox is disabled (I cannot type in the box)
        Assert.assertFalse(driver.findElement(By.xpath("//form[@id='input-example']//input")).isEnabled());

    }

}
