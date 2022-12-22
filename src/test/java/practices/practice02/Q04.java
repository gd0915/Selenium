package practices.practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q04 extends TestBase {
    /*
     Given
        Go to https://www.gmibank.com/
   When
        Hover over "Premium" Deposit Package
   And
        Click on "Book Now"
   Then
        Verify url contains "services"
     */
    @Test
    public void Test(){
        // Go to https://www.gmibank.com/
        driver.get("https://www.gmibank.com/");

        //locate the element
        WebElement premiumElement = driver.findElement(By.xpath("//h4[.='Premium']"));

        //Hover over "Premium" Deposit Package
        Actions actions = new Actions(driver);
        actions.moveToElement(premiumElement).perform();

        //Click on "Book Now"
        driver.findElement(By.linkText("Book Now")).click();

        // Verify url contains "services"
        Assert.assertTrue(driver.getCurrentUrl().contains("services"));
        //        String url = driver.getCurrentUrl();
        //        assertTrue(url.contains("services"));





    }
}
