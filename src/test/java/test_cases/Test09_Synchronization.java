package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test09_Synchronization extends TestBase {
    /*
    Create a class:Synchronization2.
    Create a method: synchronization2
    Go to https://the-internet.herokuapp.com/dynamic_loading/2
    When user clicks on the Start button
    Then verify the ‘Hello World!’ Shows up on the screen
     */
    @Test
    public void synchronizationTest(){
        //Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        //User clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();

        //Then verify the ‘Hello World!’ Shows up on the screen (By using reusable method in my framework)
        WebElement expectedText = waitForVisibility(driver.findElement(By.xpath("//div[@id='finish']//h4")), 5 );
        Assert.assertEquals("Hello World!", expectedText.getText());

    }
}
