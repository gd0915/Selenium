package test_cases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test08 extends TestBase {
    /*
    When user goes to https://jqueryui.com/autocomplete/
    And type Apple
    Then select Applescript
     */
    @Test
    public void test(){
       // When user goes to https://jqueryui.com/autocomplete/
        driver.get("https://jqueryui.com/autocomplete/");

       // Type Apple into Tags box
        driver.switchTo().frame(0);
        WebElement tagsBox = driver.findElement(By.id("tags"));
        tagsBox.sendKeys("Ap");
        driver.findElement(By.xpath("//*[@id='ui-id-1']//div")).click();
    }

}
