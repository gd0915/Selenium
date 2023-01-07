package practices.practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

public class Q02 extends TestBase {
    /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click on Ajax Loader
    And
        Click on "Click Me!" button
    Then
        Assert that button is clicked
    And
        Take screenshot after each step
     */

    @Test
    public void test2() throws IOException {

        //Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        takeScreenshotOfPage();

        //Click on Ajax Loader
        driver.findElement(By.id("button3")).click();
        takeScreenshotOfPage();

        // Click on "Click Me!" button
        //driver.findElement(By.id("button1")).click(); //If I close im[licit wait it is not going to work. Then I need to use explicit wait here.
        waitForClickability(By.id("button1"), 5).click(); //explicit wait
        takeScreenshotOfPage();

        // Assert that button is clicked
        String text = waitForVisibility(By.xpath("//h4[.='Well Done For Waiting....!!!']"), 3).getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("Well Done"));

        // Take screenshot after each step

    }

}
