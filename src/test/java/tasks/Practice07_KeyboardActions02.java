package tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Practice07_KeyboardActions02 extends TestBase {

    @Test
    public void Test(){

        //  1- Go to https://www.google.com/
        driver.get("https://www.google.com/");

        //  2-Locate the search box
        WebElement searchBox = driver.findElement(By.xpath("//*[@name='q']"));

        // 2- Type nutella into the search box letter by letter and then click Enter
        Actions actions = new Actions(driver);
        actions.
                click(searchBox).
                keyDown(Keys.SHIFT).
                sendKeys("n").
                keyUp(Keys.SHIFT).
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                sendKeys(Keys.ENTER).
                perform();








    }

}
