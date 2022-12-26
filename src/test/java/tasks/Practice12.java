package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Practice12 extends TestBase {
    /*
    1. Navigate to url 'http://automationexercise.com'
    2. Verify that home page is visible successfully
    3. Click 'View Product' for any product on home page
    4. Verify product detail is opened
    5. Increase quantity to 4
    6. Click 'Add to cart' button
    7. Click 'View Cart' button
    8. Verify that product is displayed in cart page with exact quantity
     */

    @Test
    public void test() throws InterruptedException {
    //1. Navigate to url 'http://automationexercise.com'
    driver.get("http://automationexercise.com");

    //2. Verify that home page is visible successfully
    driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();

    //3. Click 'View Product' for any product on home page
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.PAGE_DOWN).perform();
//    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

    //4. Verify product detail is opened
    //Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed();

    //5. Increase quantity to 4
    WebElement quantity =  driver.findElement(By.id("quantity"));
    quantity.clear();
    //OR
    // quantity.sendKeys(Keys.DELETE);

    quantity.sendKeys("4");
    Thread.sleep(2000);

    //6. Click 'Add to cart' button
    driver.findElement(By.xpath("//button[@type='button']")).click();

    //7. Click 'View Cart' button
    driver.findElement(By.linkText("View Cart")).click();

    //8. Verify that product is displayed in cart page with exact quantity
    String actualQuantity = driver.findElement(By.xpath("//td[@class='cart_quantity']")).getText();
    Assert.assertEquals("4" , actualQuantity);

    }
}
