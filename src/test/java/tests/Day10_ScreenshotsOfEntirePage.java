package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

public class Day10_ScreenshotsOfEntirePage extends TestBase {
    /*
    *In testing, reporting is very essential.
       - Documentation of the test results

    *Test Reports
       - Should have test steps
       - Test results(passes or failed)
       - Screenshots
            ==>>If a test case fails, then we should take screenshot for raising the bug
            ==>>If a test case pass, then we should take screenshot as a proof.

    *With selenium 3/4, taking the entire screen show is possible

    *Use TakeScreenshot api and getScreenshotAs method is used for taking the screenshot

    *With selenium 4, we can even take the screenshots of specific elements
     */

    @Test
    public void screenshotOfEntirePage() throws IOException, InterruptedException {
        //    Given user search for ‘uni’
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        driver.findElement(By.id("myCountry")).sendKeys("uni");

        // TAKE A SCREENSHOT OF ENTIRE PAGE WITH A REUSABLE METHOD
        takeScreenshotOfPage();

//        And Select United Kingdom

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
       // searchAndSelectFromList("uni", "United Kingdom");

//        TAKE A SCREENSHOT
        takeScreenshotOfPage();

//        Add click on submit button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='button']")).click();

//        TAKE A SCREENSHOT
        takeScreenshotOfPage();

//        Then verify the result contains United Kingdom
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));

//        TAKE SCREENSHOT
        takeScreenshotOfPage();

    }

}
