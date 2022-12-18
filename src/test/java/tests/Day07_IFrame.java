package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day07_IFrame extends TestBase {
    //Create a class: IFrame
    //Create a method: iframeTest
    //Go to https://the-internet.herokuapp.com/iframe
    //Verify the Bolded text contains “Editor”
    //Locate the text box
    //Delete the text in the text box
    //Type “This text box is inside the iframe”
    //Verify the text Elemental Selenium text is displayed on the page

    @Test
    public void iframeTest(){
        //Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Verify the Bolded text contains “Editor”
        //Header is not in the iframe, so not do not switch to iframe
        String header = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(header.contains("Editor"));

        // Locate the text box
        //NOTE: TextBox is in the iframe, so we have to switch to the iframe
        driver.switchTo().frame(0);

        //Delete the text in the text box
        WebElement box = driver.findElement(By.xpath("//p"));
        box.clear();

        //Type “This text box is inside the iframe”
        box.sendKeys("This text box is inside the iframe");

        //SO FAR DRIVER IS IN THE IFRAME BUT Elemental Selenium text IS OUTSIDE OF THE FRAME
        //GETTING OUT OF THE FRAME
        driver.switchTo().parentFrame();
        //ALTERNATIVELY WE CAN USE defaultContent()
        //Verify the text Elemental Selenium text is displayed on the page
        WebElement linkText = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkText.isDisplayed());

    }

}
