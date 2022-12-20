package test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test02_GoogleSearchTest {

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

    @Test
    public void test() throws InterruptedException {
//      locate search box and search for "porcelain teapot"
        driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("porcelain teapot");
//      click Google Search
        driver.findElement(By.xpath("//*[@value='Google Search']")).click();
        Thread.sleep(2000);


//      And print how many related results displayed on Google
        WebElement resultText = driver.findElement(By.id("result-stats"));
        String result = resultText.getText();
        System.out.println(result);
    }

    @After
    public void tearDown(){
       driver.quit();
    }


}
