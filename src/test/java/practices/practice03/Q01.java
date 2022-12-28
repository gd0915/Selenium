package practices.practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q01 extends TestBase {
    /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below them
    Then
        Verify they are dropped.
 */
    @Test
    public void test(){
    //Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

    //Drag orange elements on proper boxes below them
        WebElement source1 = driver.findElement(By.id("credit2"));
        WebElement target1 = driver.findElement(By.id("bank"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source1, target1).perform();

        WebElement source2 = driver.findElement(By.id("credit1"));
        WebElement target2 = driver.findElement(By.id("loan"));
        actions.dragAndDrop(source2, target2).perform();

        WebElement source3 = driver.findElement(By.id("fourth"));
        WebElement target3 = driver.findElement(By.id("amt7"));
        actions.dragAndDrop(source3, target3).perform();

        WebElement source4 = driver.findElement(By.id("fourth"));
        WebElement target4 = driver.findElement(By.id("amt8"));
        actions.dragAndDrop(source4, target4).perform();

        //  Verify they are dropped.
        Assert.assertTrue(driver.findElement(By.linkText("Perfect!")).isDisplayed());

    }

}
