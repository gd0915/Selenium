package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day14_StaleElementException extends TestBase {

    @Test
    public void staleElementException1(){
        driver.get("https://www.techproeducation.com");
        //locating LMS LOGIN
       WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
       // clicking LMS LOGIN
       lmsLogin.click();
        waitFor(5);
       // going back home page
       driver.navigate().back();
        waitFor(5);
       //clicking LMS LOGIN

       //        FAILED cause lmsLogin is no longer fresh. It is OLD. It is STALE
        lmsLogin.click();//org.openqa.selenium.StaleElementReferenceException:

       //        SOLUTION : RELOCATE THE ELEMENT
       //        driver.findElement(By.linkText("LMS LOGIN")).click();

    }


}
