package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_LinkTexts {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void LMSPage() {
        driver.get("https://techproeducation.com/");

        //Click on LMS LOGIN
        //LMS LOGIN IS A LINK
        //TEXT OF THAT LINK "LMS LOGIN"
        driver.findElement(By.linkText("LMS LOGIN")).click();//linkText() method is case sensitive

        //Verify lms page is visible
        String expectedURL = "https://lms.techproeducation.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("LMS LOGIN PAGE IS NOT DISPLAYED",expectedURL, actualURL);
        //message will ONLY BE VISIBLE IF ASSERTION FAILS: LMS LOGIN PAGE IS NOT DISPLAYED
    }

    @Test
    public void LMSPagePartialLinkText(){
        driver.get("https://techproeducation.com/");
        driver.findElement(By.partialLinkText("LMS L")).click();//Case sensitive
        //ALTERNATIVELY WE CAN LOCATE A CORE ELEMENT ON LMS PAGE AND CHECK IF THAT ELEMENT IS DISPLAYED ON THE PAGE
        WebElement loginElement = driver.findElement(By.linkText("Login/Register"));
        Assert.assertTrue(loginElement.isDisplayed());//isDisplayed() method returns TRUE if element is displayed on the page. ==>PASS
                                                      //isDisplayed() method returns FALSE if element is NOT displayed on the page.==>FAIL

        //Assert.assertTrue(driver.findElement(By.linkText("Login/Register")).isDisplayed();//alternative way to type assertion code
    }


}
/*
NOTE:
There are two ways to understand if an element is a link.
1. <a href........> </a> tag ==>
2. When we click on the link after we are inspecting on the element if it takes us to a new page, so that means is this a link.

-  In the linkText() we use the complete text.
-  In partialLinkText() we use a part of the link text.
-  If the link text is huge, we can prefer just to use a good amount of that link text.
-  To locate anything we see on the page, we can use XPath.
-  We can use linkText() and partialLinkText() for only links.
 */
