package test_cases;

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

public class Test03_GoogleTest {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//      User goes to https://www.google.com/
        driver.get("https://www.google.com/");
    }

    //1.Verify if the title is "Google"
    @Test
    public void titleTest(){
        //Verify if google title is "Google"
        String title = driver.getTitle();
        System.out.println("Title : "+ title);
        Assert.assertEquals("Google", title);
    }

    //2.Verify if google image displays or not
    @Test
    public void imageTest(){
       WebElement img = driver.findElement(By.id("hplogo"));
       Assert.assertTrue(img.isDisplayed());
    }

    //3.Verify if the Gmail link is displayed
    @Test
    public void gmailLinkTest(){
        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        Assert.assertTrue(gmail.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
