package practices.practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Q03 extends TestBase {
    /*
    /*
    Given
        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    When
        Click all the buttons
    Then
        Assert all buttons clicked
     */
    @Test
    public void test(){
        // Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        // Click all the buttons
        Actions actions = new Actions(driver);

        //clicking on "onBlur" button
        driver.findElement(By.id("onblur")).click();
        waitFor(2);
        driver.findElement(By.id("onclick")).click();
        waitFor(2);

        // clicking on "onClick" button
        driver.findElement(By.id("onclick")).click();
        waitFor(2);

        // clicking on "onContextMenu" button
        // clicking on "onDoubleClick" button
        // clicking on "onFocus" button
        // clicking on "keyDown" button
        // clicking on "keyUp" button
        // clicking on "keyPress" button
        // clicking on "onMouseOver" button
        // clicking on "onMouseLeave" button
        // clicking on "onMouseDown" button

        WebElement contextMenuButton = driver.findElement(By.id("oncontextmenu"));
        WebElement doubleClickButton = driver.findElement(By.id("ondoubleclick"));
        WebElement focusButton = driver.findElement(By.id("onfocus"));
        WebElement keyDownButton = driver.findElement(By.id("onkeydown"));
        WebElement keyUpButton = driver.findElement(By.id("onkeyup"));
        WebElement keyPressButton = driver.findElement(By.id("onkeypress"));
        WebElement mouseOverButton = driver.findElement(By.id("onmouseover"));
        WebElement mouseLeaveButton = driver.findElement(By.id("onmouseleave"));
        WebElement mouseDownButton = driver.findElement(By.id("onmousedown"));


        actions.contextClick(contextMenuButton).perform();
        waitFor(1);
        actions.doubleClick(doubleClickButton).perform();
        waitFor(1);
        actions.click(focusButton). perform();
        waitFor(1);
        actions.click(keyDownButton).sendKeys(Keys.ENTER). perform(); //any keyboard button is going to work
        waitFor(1);
        actions.click(keyUpButton).sendKeys(Keys.ENTER). perform();
        waitFor(1);
        actions.click(keyPressButton).sendKeys(Keys.ENTER). perform();
        waitFor(1);
        actions.moveToElement(mouseOverButton). perform();
        waitFor(1);
        actions.moveToElement(mouseLeaveButton). perform();
        waitFor(1);
        actions.click(mouseDownButton).perform();//Because of previous leave action, this one did not work
        waitFor(1);
        actions.click(mouseDownButton).perform();

        // Assert all buttons clicked
        //1st way
        List<WebElement> allTexts = driver.findElements(By.xpath("//p[.='Event Triggered']"));
        Assert.assertEquals(11, allTexts.size());

        //2nd way
        int numberOfClickedButtons = driver.findElements(By.xpath("//p[.='Event Triggered']")).size();
        Assert.assertEquals(11, numberOfClickedButtons);

    }

}
