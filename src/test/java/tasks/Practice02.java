package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice02 {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://www.hurriyet.com.tr/");
    }

    @Test
    public void closePopUps() throws InterruptedException {
        Thread.sleep(3000);
        //locating and close first pop-up
       // driver.findElement(By.xpath("//*[text()='Daha Sonra']")).click();
        driver.findElement(By.xpath("//*[@id='btn-later']")).click();

        //go to "spor arena" at the top of the page
        driver.findElement(By.xpath("(//a[text()='SPOR ARENA'])[2]")).click();

        //locating and close second pop-up
        driver.findElement(By.xpath("//*[@id='intclose']")).click();

        //click on the team sign you like
        driver.findElement(By.xpath("//*[@id='top-team-section-id']/ul/li[3]/a/div/img")).click();




    }
}
