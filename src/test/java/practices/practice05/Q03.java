package practices.practice05;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class Q03 extends TestBase {
    /*
    Given
        Go to https://www.facebook.com/
    When
        Click on "Create New Account"
    And
        Fill all the boxes by using keyboard actions class
     */

    @Test
    public void test03(){
        // Go to https://www.facebook.com/
        driver.get("https://www.facebook.com/");

        // Click on "Create New Account"
        driver.findElement(By.linkText("Create new account")).click();

        //  Fill all the boxes by using keyboard actions class
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions = new Actions(driver);
        Faker faker =new Faker();

        actions.
                click(firstNameBox).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("Dec").
                sendKeys(Keys.TAB).sendKeys("10").
                sendKeys(Keys.TAB).sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

    }
}
