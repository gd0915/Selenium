package tasks;

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

public class Practice01 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        //driver.get("https://www.udemy.com/join/login-popup/?locale=en_US&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2F");
        driver.get("https://www.udemy.com/");
    }

    @Test
    public void dynamicXpath() throws InterruptedException {

        //locating the Log in and clicking
        WebElement login = driver.findElement(By.xpath("//*[text()='Log in']"));
        login.click();

        //locating Email and typing the email
        WebElement email = driver.findElement(By.xpath("//*[@id='form-group--1']"));
        email.sendKeys("haticeesozeri@gmail.com");


     //   Thread.sleep(3000);

        //locating the password and typing
        WebElement password = driver.findElement(By.xpath("//input[@id = 'form-group--3']"));
        password.sendKeys("GokhanDefne0915");

        //locating the Log in and clicking
        WebElement login2 = driver.findElement(By.xpath("//*[text()='Log In']"));
        login2.click();

        //Locating the search box and typing Java Practice Tests
        WebElement searchBox = driver.findElement(By.xpath("//*[@placeholder='Search for anything']"));
        searchBox.sendKeys("Java Practice Tests");

        //Click magnifying glass
        driver.findElement(By.xpath("//*[@id='udemy']/div[1]/div[1]/div[3]/div[2]/form/button/svg")).click();

        //Verify Java Practice Test is displayed
        WebElement element = driver.findElement(By.xpath("//a[text()='Java Practice Tests']"));
        Assert.assertTrue(element.isDisplayed());

    }

    @After
    public void tearDown(){
       // driver.quit();
    }

}
//*[@name='email']
