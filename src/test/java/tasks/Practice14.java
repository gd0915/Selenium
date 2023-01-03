package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Practice14 extends TestBase {
    /*
            1. Navigate to url 'http://automationexercise.com'
            2. Verify that home page is visible successfully
            3. Add products to cart
            4. Click 'Cart' button
            5. Verify that cart page is displayed
            6. Click 'X' button corresponding to particular product
            7. Verify that product is removed from the cart
     */

    @Test
    public void test() throws InterruptedException {
        // 1. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 2. Verify that home page is visible successfully
        driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();

        // 3. Add products to cart
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();

        // 4. First Click "Continue to Shopping" button and then Click 'Cart' button
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        // 5. Verify that cart page is displayed
        driver.findElement(By.id("cart_items")).isDisplayed();

        // 6. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();
        Thread.sleep(2000);

        // 7. Verify that product is removed from the cart
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Cart is empty!']")).isDisplayed());

    }


}
