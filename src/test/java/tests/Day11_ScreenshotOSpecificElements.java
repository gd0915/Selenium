package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class Day11_ScreenshotOSpecificElements extends TestBase {
    /*
        Acceptance Criteria:
        When user goes to the application home page(techproeducation)
        Then verify the logo of techpro education is displayed
     */
    @Test
    public void screenshotTest() throws IOException, InterruptedException {
        driver.get("https://www.techproeducation.com");
        WebElement techProEdLogo = driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        //verifying the logo
        Assert.assertTrue(techProEdLogo.isDisplayed());
        //taking the screenshot as proof
        // techProLogo.getScreenshotAs(OutputType.FILE);
        // OR CALLING REUSABLE METHOD to get the screenshot of the element
        takeScreenshotOfTheElement(techProEdLogo);

        // Taking screenshot of social media icons
        Thread.sleep(2000);
        WebElement socials = driver.findElement(By.xpath("//div[@data-id='d7545f2']"));
        takeScreenshotOfTheElement(socials);

    }
}
