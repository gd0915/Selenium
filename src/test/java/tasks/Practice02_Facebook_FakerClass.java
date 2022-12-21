package tasks;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Practice02_Facebook_FakerClass {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        //Go to the facebook homepage "https://www.facebook.com"
        driver.get("https://www.facebook.com");
    }

    @Test
    public void facebookCreateNewAccount() throws InterruptedException {
       //click on "Create a New Account"
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

       //First locate the firstname box and then fill the form by switching the boxes with the TAB button and finally click on Sign Up
       // Note: Use Faker class to get the fake data
        WebElement firstNameBox = driver.findElement(By.xpath("//*[@name='firstname']"));

       Actions actions = new Actions(driver);
       Faker faker =new Faker();

       actions.click(firstNameBox).
               sendKeys(faker.name().firstName())
               .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
               .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
               .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB).sendKeys("Dec")
               .sendKeys(Keys.TAB).sendKeys("10")
               .sendKeys(Keys.TAB).sendKeys("2000")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.ENTER)
               .build()
               .perform();
                Thread.sleep(5000);
    }
}
