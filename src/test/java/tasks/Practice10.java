package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Practice10 extends TestBase {
    /*
      Navigate to url 'http://automationexercise.com'
      Verify that home page is visible successfully
      Click 'Products' button
      Hover over first product and click 'Add to cart'
      Click 'Continue Shopping' button
      Hover over second product and click 'Add to cart'
      Click 'View Cart' button
      Verify both products are added to Cart
      Verify their prices, quantity and total price
     */

    @Test
    public void test(){
        // 1. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 2. Verify that home page is visible successfully
        boolean textIsDisplayed = driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();
        Assert.assertTrue(textIsDisplayed);

        // 3.  Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // 4. Hover over first product and click 'Add to cart'
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='product-overlay'])[1]"));
//        actions.moveToElement(firstProduct).perform();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();

        // 5. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

        // 6. Hover over second product and click 'Add to cart'
        driver.findElement((By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]"))).click();

        // 7. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        // 8. Verify both products are added to Cart
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).isDisplayed();
        driver.findElement(By.xpath("//a[@href='/product_details/2']")).isDisplayed();

        // 9. Verify their prices, quantity and total price
        driver.findElement(By.xpath("//td[@class='cart_price']")).isDisplayed();
        driver.findElement(By.xpath("//td[@class='cart_quantity']")).isDisplayed();
        driver.findElement(By.xpath("//td[@class='cart_total']")).isDisplayed();

        driver.findElement(By.xpath("(//td[@class='cart_price'])[2]")).isDisplayed();
        driver.findElement(By.xpath("(//td[@class='cart_quantity'])[2]")).isDisplayed();
        driver.findElement(By.xpath("(//td[@class='cart_total'])[2]")).isDisplayed();


    }
}
