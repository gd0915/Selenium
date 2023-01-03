package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class Day13_JSExecutor extends TestBase {
/*
        When user goes to home page
        And scroll on the WE OFFER element
        And scroll on the search box element
 */
    @Test
    public void scrollIntoViewTest() throws IOException {
        // When user goes to home page
        driver.get("https://www.techproeducation.com");

        // Adding hard wait with reusable method
        waitFor(3);

        // 1. Create js executor Object
        JavascriptExecutor js = (JavascriptExecutor)driver;

        waitFor(3);
        // 2. Execute the command
        // scrolling "we offer" element
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[.='we offer']"))); //coming from Selenium
        takeScreenshotOfPage();

        waitFor(3);
        // scrolling Enroll Free element
        //js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.linkText("Home")));
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
        takeScreenshotOfPage();

        waitFor(3);
        // scrolling WHY US? element
        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        takeScreenshotOfPage();


        waitFor(3);
        // scrolling back up to enroll free
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
        takeScreenshotOfPage();

        // scroll all the way down
        scrollAllDownByJS();
        waitFor(3);
        takeScreenshotOfPage();

        // scroll all the way up
        scrollAllUpByJS();
        waitFor(3);
        takeScreenshotOfPage();

    }

    @Test
    public void clickByJSTest(){
        driver.get("https://www.techproeducation.com");
//        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
//        clickByJS(lmsLogin);

        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));
    }

    @Test
    public void typeInTheInputTest(){
        driver.get("https://www.techproeducation.com");
        setValueByJS(driver.findElement(By.xpath("//input[@type='search']")), "QA");
    }

    @Test
    public void getValue(){
        driver.get("https://www.priceline.com/");
        getValueByJS("hotelDates"); //We are able to get the default value of the Check-in Check-out box
                                              //This is one of the limitations of the selenium because normally, we cannot get the value of an attribute with selenium
    }

    @Test
    public void colorByJSTest(){
        driver.get("https://www.priceline.com/");
        changeBackgroundColorByJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"red");
        addBorderWithJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"5px solid green");
    }

}
