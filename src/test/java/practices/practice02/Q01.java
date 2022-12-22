package practices.practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q01 extends TestBase {
    /*
    Given
         Go to url : https://phptravels.com/demo/
    When
         Fill the form
    And
         Click on 'SUBMIT'
    Then
         Assert that the form has been sent
     */
    @Test
    public void alertTest(){
        // Go to url : https://phptravels.com/demo/
        driver.get("https://phptravels.com/demo/");

        // Fill the form
         driver.findElement(By.name("first_name")).sendKeys("John");
         driver.findElement(By.name("last_name")).sendKeys("Doe");
         driver.findElement(By.name("business_name")).sendKeys("QA Engineer");
         driver.findElement(By.name("email")).sendKeys("johndoe@gmail.com");
         int num1 = Integer.valueOf(driver.findElement(By.id("numb1")).getText());
         int num2 = Integer.parseInt(driver.findElement(By.id("numb2")).getText());
         String result = num1+num2+""; //We convert it into String by adding "" and doing concatenation
         driver.findElement(By.id("number")).sendKeys(result);//sendKeys() method is working with String that is why we convert it int result into a String by doing concatenation

         // Click on 'SUBMIT'
         driver.findElement(By.id("demo")).click();

         //Assert that the form has been sent
        WebElement thankYou = driver.findElement(By.xpath("//strong[.=' Thank you!']"));
        Assert.assertTrue(thankYou.isEnabled());

        /*
        Because of waiting issue isDisplayed method did not work. We can add Thread.sleep(5000), then isDisplayed is also working.
         */




    }
}
