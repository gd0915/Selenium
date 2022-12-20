package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Practice06_KeyBoardActions extends TestBase {
    @Test
    public void actions() throws InterruptedException {
        //Go to the  https://html.com/tags/iframe/
        driver.get("https://html.com/tags/iframe/");

        //Scroll down to see the video on the page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //Click Play button to watch the video
        driver.switchTo().frame(driver.findElement(By.xpath(" //*[@id='post-164']/div/div[3]/iframe")));
        driver.findElement(By.xpath("//*[@id='movie_player']/div[4]/button")).click();

        //Verify you run the video
        Thread.sleep(2000);
        WebElement link = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(link.isDisplayed());

    }
}
