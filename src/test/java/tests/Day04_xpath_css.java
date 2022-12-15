package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Day04_xpath_css {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void loginTest(){
//        locating username and typing username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
//        locating password and typing password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
//        locating login button and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void loginTestCss(){
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    /*
     * How many locators are there?
     * What are they?
     * Which one do you prefer? Why?
     * What is difference between absolute xpath and relative xpath?
     * What is the difference between xpath and css selector?
     * */

}
/*
Note:
TagNames are dynamic. We do not have to put any tag name. Instead of the tagName we can put '*'.
// driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123"); ==> '*' means any tag
// driver.findElement(By.xpath("//*[.='password']")).sendKeys("admin123"); ==> '.'  means any attribute
// Exmp: //*[.='Login']
 */

