package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Q02 extends TestBase {
/*
    Given
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
        Click on the "Animals and Nature" emoji
    And
        Click all the "Animals and Nature"  emoji elements
    And
        Fill the form
    And
        Press the apply button
    Then
        Verify "code" element is displayed
     */

    @Test
    public void test() throws InterruptedException {
        //Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");


        //  First we need to switch to iframe
        driver.switchTo().frame("emoojis");

        //  Click on the "Animals and Nature" emoji
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();

        //  Click all the "Animals and Nature"  emoji elements
        List<WebElement> allSecondEmojies = driver.findElements(By.xpath("//*[@id='nature']/div/img"));
//        for(WebElement eachEmoji : allSecondEmojies){
//            eachEmoji.click();
//        }

        //using lambda is recommended
        allSecondEmojies.forEach(WebElement::click);
        //allSecondEmojies.stream().forEach(w->w.click());

        // Go back to the parent iframe
        driver.switchTo().parentFrame();

        // Fill the form
        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        List<String> words = new ArrayList<>(Arrays.asList("My Fav Emoji", "Cute Smile", "Beach", "Fries", "Jogging", "Banf", "Computer", "Heart", "HH", "Tab", "End"));
        for(int i=0; i<inputs.size(); i++){
            inputs.get(i).sendKeys(words.get(i));
        }

        //Press the apply button
        driver.findElement(By.id("send")).click();

        // Verify "code" element is displayed
        WebElement code = driver.findElement(By.id("code"));
        assertTrue(code.isDisplayed());



    }
}
