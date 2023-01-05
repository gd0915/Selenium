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
        // scrollIntoView(true) method will automatically understand which direction should to go down/up/right/left depends on the location of the element.
        // That is why it's a very useful method.

        // When user goes to home page
        driver.get("https://www.techproeducation.com");

        // Adding hard wait with reusable method
        waitFor(3);

        // 1. Create js executor Object
        JavascriptExecutor js = (JavascriptExecutor)driver; //We are doing "Down casting", and we imported the library==>>org.openqa.selenium.JavascriptExecutor

        waitFor(3);
        // 2. Execute the command
        // scrolling "we offer" element
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[.='we offer']"))); //Coming from Selenium
        //We have js object to execute the Javascript code.
        //Script – This is the JavaScript that needs to execute.
        //Arguments – It is the arguments to the script. It’s optional.
        takeScreenshotOfPage();

        waitFor(3);
        // scrolling Enroll Free element
        // if an element is already visible js executor will not move
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
                                              //This is one of the limitations of the selenium because normally, we cannot get the value of the value attribute(default value) with selenium
    }

//    @Test
//    public void typeInTheInputTest1(){
//        driver.get("https://www.priceline.com/");
//        driver.findElement(By.id("hotelDates")).click();
//        setValueByJS(driver.findElement(By.id("hotelDates")), "21/01/2023 – 11/02/2023");
//    }

    @Test
    public void colorByJSTest(){
        driver.get("https://www.priceline.com/");
        changeBackgroundColorByJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"red");
        addBorderWithJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"5px solid green");
    }

}
/*
===>>>What is JS Executor?
    It is an API that is used to execute javascript comments in Selenium
    JS Executor is coming from Selenium
===>>>Why we are using javascript executor?
    We may need js methods to interact with web element, when traditional selenium
    methods are not enough(such as click, scrolling into specific element,…)
===>>>What we can do with JS executor?
    Click. Especially good with clicking hidden element
    Scroll onto specific elements, scroll the all the way down/up/right/left
    Type in an input
    Change the value of an element
    Hover over
    Change the color, background color, add border
 */
