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

public class Day03_Locators {
    WebDriver driver;

    @Before
    public void setUp(){
//      user goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        WebDriverManager.chromedriver().setup();;
        WebDriver driver = new ChromeDriver();
//          IMPLICIT WAIT
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void logInTest() {

//        Locating the username and typing the password
        WebElement username = driver.findElement(By.name("username"));//NOTE: if there are multiple match, findElement() method returns the first one.
        username.sendKeys("Admin");//typing Admin
        driver.findElement(By.name("username")).sendKeys("Admin");

        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("admin123");

//      Locating the button and clicking
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

//       Verifying log in is successful
//       1. We can use default page url to do assertion
//       2. Or we can locate a CORE ELEMENT on the default page to assert is that element is displayed on the page
//      Login page = https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//      Default page =  https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index ->If url contains "dashboard" that means we are log in successfully

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals("LOGIN FAILED", expectedURL, actualURL);//If login successful PASS, if not FAIL and print message LOGIN FAILED"


//      NOTE : We do not need to use containers. We can use method chain in selenium
//        driver.findElement(By.name("username")).sendKeys("Admin");
//        driver.findElement(By.name("password")).sendKeys("admin123");
//        driver.findElement(By.tagName("button")).click();
    }

        @After
        public void tearDown(){
            driver.quit();
        }

}
