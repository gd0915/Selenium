package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

public class Day10_ScreenshotsOfEntirePage extends TestBase {

    @Test
    public void screenshotOfEntirePage() throws IOException {
        //    Given user search for ‘uni’
            driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        // TAKE A SCREENSHOT OF ENTIRE PAGE WITH A REUSABLE METHOD
        takeScreenshotOfPage();


        //COMPLETE AS HOMEWORK
//        And select United Kingdom
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        driver.findElement(By.xpath("@div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();

//        TAKE SCREENSHOT
        takeScreenshotOfPage();

//        Add click on submit button
//        TAKE SCREENSHOT
//        Then verify the result contains united Kingdom
//        TAKE SCREENSHOT

    }


}
