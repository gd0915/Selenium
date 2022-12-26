package tasks;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Practice09 extends TestBase {
    //      User goes https://phptravels.com/demo
    //      User fill the form with Faker
    //      User check the question and fill in the blank with correct answer
    //      User click the submit button

    @Test
    public void test() throws InterruptedException {
        //      User goes https://phptravels.com/demo
        driver.get("https://phptravels.com/demo");

        //  User fill the form with Faker
        Faker faker = new Faker();

        // locate the web element user name
        WebElement usernameBox = driver.findElement(By.xpath("//*[@name='first_name']"));
        Actions actions = new Actions(driver);

        actions.click(usernameBox).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                perform();

        //      User check the question and fill in the blank with correct answer
        WebElement numberOne = driver.findElement(By.id("numb1"));
        int numberOneInteger = Integer.parseInt(numberOne.getText());
        WebElement numberTwo = driver.findElement(By.id("numb2"));
        int numberTwoInteger = Integer.parseInt(numberTwo.getText());
        String result = String.valueOf(numberOneInteger + numberTwoInteger);

        driver.findElement(By.id("number")).sendKeys(result);

        //      User click the submit button
        driver.findElement(By.id("demo")).click();

        //      Verify
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement text = driver.findElement(By.xpath("//strong[.=' Thank you!']"));
        Assert.assertTrue(text.isEnabled());

    }
}
