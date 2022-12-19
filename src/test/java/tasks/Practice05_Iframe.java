package tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice05_Iframe extends TestBase {
    /*
    // User goes to the URL "https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/"
    // maximize the window
    // Click on the second emoji
    // Click on all second emoji elements
    // Go back to the parent iframe
    // Fill the form (as you wish)
    // Click on "Apply button"
 */

    @Test
    public void test() throws InterruptedException {
        // User goes to the URL "https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/"
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // maximize the window
       // driver.manage().window().maximize();

        // Click on the second emoji
        //First we need to switch to iframe
        driver.switchTo().frame("emoojis");
        Thread.sleep(1000);
        //Click on the second emoji
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        //  Click on all second emoji elements
        List<WebElement> allSecondEmojies = driver.findElements(By.xpath("//*[@id='nature']/div/img"));
        for(WebElement eachEmoji : allSecondEmojies){
            eachEmoji.click();
        }

        Thread.sleep(3000);

        // Go back to the parent iframe
        driver.switchTo().parentFrame();

        // Fill the form (as you wish)
        List<WebElement> listOfTextBoxes = driver.findElements(By.xpath("//input[@class='mdl-textfield__input'] "));
        List<String> inputList = new ArrayList<>(Arrays.asList("My Fav Emoji", "Cute Smile", "Beach", "Fries", "Jogging", "Banf", "Computer", "Heart", "HH", "Tab", "End"));
        for(int i=0; i<listOfTextBoxes.size();i++){
            listOfTextBoxes.get(i).sendKeys(inputList.get(i));
        }
        Thread.sleep(3000);

        //Click on "Apply button"
        driver.findElement(By.xpath("//button[@id='send']")).click();

    }


}
