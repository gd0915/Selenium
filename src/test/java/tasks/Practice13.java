package tasks;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Practice13 extends TestBase {
    /*
    Navigate to url 'http://automationexercise.com'
    Verify that home page is visible successfully
    Add products to cart
    Click Continue button and then click 'Cart' button
    Verify that cart page is displayed
    Click Proceed To Checkout
    Click 'Register / Login' button
    Fill all details in Signup and create account
    Verify 'ACCOUNT CREATED!' and click 'Continue' button
    Verify ' Logged in as username' at top
    Click 'Cart' button
    Click 'Proceed To Checkout' button
    Verify Address Details and Review Your Order
    Enter description in comment text area and click 'Place Order'
    Click 'Pay and Confirm Order' button
    Verify success message 'Your order has been placed successfully!'
    Click 'Delete Account' button

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
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        Thread.sleep(2000);

        // 4. Click Continue button and then click 'Cart' button
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        // 5. Verify that cart page is displayed
        driver.findElement(By.xpath("//td[@class='cart_product']")).isDisplayed();

        // 6. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        // 7. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();

        // 8. Fill all details in Signup and create account
        WebElement nameBox = driver.findElement(By.xpath("//input[@type='text']"));
        Faker faker = new Faker();
        actions.
                click(nameBox).
                sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress() + Keys.ENTER).
                perform();

        // gender
        Thread.sleep(2000);
        driver.findElement(By.id("id_gender2")).click();
        // password
        driver.findElement(By.id("password")).sendKeys(faker.internet().password());

        // DOB
        WebElement dropdownDays = driver.findElement(By.id("days"));
        Select select = new Select(dropdownDays);
        select.selectByValue("22");

        Thread.sleep(2000);
        WebElement dropdownMonths = driver.findElement(By.id("months"));
        Select select2 = new Select(dropdownMonths);
        select2.selectByValue("10");

        WebElement dropdownYears = driver.findElement(By.xpath("//select[@data-qa='years']"));
        Select select3 = new Select(dropdownYears);
        select3.selectByVisibleText("1991");

        // Select Checkbox
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        // Fill address information
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Doe");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("jd");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Canada");
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("Canada");

        WebElement countryDropdown = driver.findElement(By.id("country"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("Canada");

        driver.findElement(By.id("state")).sendKeys(faker.address().state());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("zipcode")).sendKeys(faker.address().zipCode());
        driver.findElement(By.id("mobile_number")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        // 9. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed();
        driver.findElement(By.linkText("Continue")).click();

        // 10. Verify ' Logged in as username' at top
        driver.findElement(By.xpath("//div//li[10]")).isDisplayed();

        // 11. Click 'Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        // 12. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        // 13. Verify Address Details and Review Your Order
        driver.findElement(By.xpath("//*[text()='Address Details']")).isDisplayed();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[text()='Review Your Order']")).isDisplayed();

        // 14. Enter description in comment text area and click 'Place Order'
        WebElement textArea = driver.findElement(By.xpath("//textarea[@class='form-control']"));
        textArea.sendKeys("I just placed my order, and I would appreciate if you could send it out before Christmas.");
        driver.findElement(By.xpath("//*[@href='/payment']")).click();

        // 15. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameOnCard = driver.findElement(By.xpath("//input[@name='name_on_card']"));
        actions.click(nameOnCard).
                sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.business().creditCardNumber()).
                sendKeys(Keys.TAB).
                sendKeys(faker.number().digits(3)).
                sendKeys(Keys.TAB).
                sendKeys(faker.business().creditCardExpiry()).
                sendKeys(Keys.TAB).
                sendKeys(faker.business().creditCardExpiry()).perform();

        // 16. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        // 17. Verify success message 'Your order has been placed successfully!'
        WebElement message = driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']"));
        String actualMessage = message.getText();
        Assert.assertEquals("Congratulations! Your order has been confirmed!", actualMessage);

        // 18. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();

    }
}
