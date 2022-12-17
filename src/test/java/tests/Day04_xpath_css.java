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
    /*
    * How many locators are there?
    * ---8 locator.
    * What are they?
    * ---id, name, className, linkText, tagName, partialLinkText, xpath, css
    * Which one do you prefer? Why?
    * ---Ahmet's answer :
    * -First If there is an ID I use id, cause id is unique and faster
    * -If there is no id then I use name if there is a unique name
    * -I also sometime create dynamic xpath. Because some elements do not have stable attributes like id and name. And I can write xpath for any element.
    * -I sometimes even use css selector instead of xpath. But i personally use xpath more than css.
    * What is difference between absolute xpath and relative xpath?
    * -Absolute xpath we start from the parent and go child elements one by one
    * -Absolute xpath use /
    * -Absolute xpath may easily be broken when a new element is added on the page
    * -For this reason we should never use absolute xpath. In fact, my team don't let QA's use absolute xpath.
    * --Relative xpath we don't start from parent and go child one by one. We go straight to the element
    * --Relative xpath use //
    * --Relative xpath is very reliable It doesn't easy brake, because absolute xpath doesn't dependent on other element
    * --I use absolute xpath in my framework when to locate the elements
    * What is the difference between xpath and css selector?
    * -First xpath and css are similar. Both are helpful and there are different ways to create xpath or css
    * -Syntax is a little different.
    * --in xpath we use // and @, but in css we don't
    * --css is a little faster than xpath(way less than 1 second). xpath does navigation in the html that takes a little bit time
    * --there are more ways to write xpath. For example, dynamic xpath has contains, starts-with, ends-with functions
    * */


}
/*
Note:
TagNames are dynamic. We do not have to put any tag name. Instead of the tagName we can put '*'.
// driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123"); ==> '*' means any tag
// driver.findElement(By.xpath("//*[.='password']")).sendKeys("admin123"); ==> '.'  means any attribute
// Exmp: //*[.='Login']
 */

