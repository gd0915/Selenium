package tasks;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class Practice11 extends TestBase {
    /*
    1. Navigate to url 'http://automationexercise.com'
    2. Verify that home page is visible successfully
    3. Click 'Cart' button
    4. Scroll down to footer
    5. Verify text 'SUBSCRIPTION'
    6. Enter email address in input and click arrow button
    7. Verify success message 'You have been successfully subscribed!' is visible
     */

    @Test
    public void test(){
      //1. Navigate to url 'http://automationexercise.com'
      driver.get("http://automationexercise.com");

      //2. Verify that home page is visible successfully
      driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();

      //3. Click 'Cart' button
      driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

      //4. Scroll down to footer
      Actions actions = new Actions(driver);
      actions.sendKeys(Keys.PAGE_DOWN).perform();

      //5. Verify text 'SUBSCRIPTION'
      driver.findElement(By.xpath("//h2")).isDisplayed();

      //6. Enter email address in input and click arrow button
      Faker faker = new Faker();
      driver.findElement(By.id("susbscribe_email")).sendKeys(faker.internet().emailAddress() + Keys.ENTER);

      //7. Verify success message 'You have been successfully subscribed!' is visible
      driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']")).isDisplayed();

    }


}
