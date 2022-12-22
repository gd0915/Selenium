package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q05 extends TestBase {
    /*
    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Match the capitals by country.
     */
    @Test
    public void test(){
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Match the capitals by country.
        Actions actions = new Actions(driver);

        //locate the web element
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement target1 = driver.findElement(By.id("box101"));

        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement target2 = driver.findElement(By.id("box102"));

        WebElement washington = driver.findElement(By.id("box3"));
        WebElement target3 = driver.findElement(By.id("box103"));

        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement target4 = driver.findElement(By.id("box104"));

        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement target5 = driver.findElement(By.id("box105"));

        WebElement rome = driver.findElement(By.id("box6"));
        WebElement target6 = driver.findElement(By.id("box106"));

        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement target7 = driver.findElement(By.id("box107"));

        actions.dragAndDrop(oslo, target1)
                        .dragAndDrop(stockholm, target2)
                        .dragAndDrop(washington, target3)
                        .dragAndDrop(copenhagen, target4)
                        .dragAndDrop(seoul, target5)
                        .dragAndDrop(rome, target6)
                        .dragAndDrop(madrid, target7).build().perform();

//        actions.dragAndDrop(oslo, target1).perform();
//        actions.dragAndDrop(stockholm, target2).perform();
//        actions.dragAndDrop(washington, target3).perform();
//        actions.dragAndDrop(copenhagen, target4).perform();
//        actions.dragAndDrop(seoul, target5).perform();
//        actions.dragAndDrop(rome, target6).perform();
//        actions.dragAndDrop(madrid, target7).perform();


    }
}
