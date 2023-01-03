package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test05 extends TestBase {
    /*
        When user goes to https://jqueryui.com/accordion/
        And user clicks on Section2 accordion
        Verify the text contains “Sed non urna.”
     */

    @Test
    public void test(){
        //  When user goes to https://jqueryui.com/accordion/
        driver.get("https://jqueryui.com/accordion/");

        //  And user clicks on Section2 accordion
        driver.switchTo().frame(0);
        driver.findElement(By.id("ui-id-3")).click();

        //Verify the text contains “Sed non urna.”
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='ui-id-4']/p")).getText().contains("Sed non urna."));

    }
}
