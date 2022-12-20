package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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
import java.util.Set;

public class Practice01_WindowHandle {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/");
    }

    @Test
    public void test() {
        // 1. Scroll down to "Login Portal"
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
       String firstPage = driver.getWindowHandle();

        // 2.Click on the "Login Portal"
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

        // 3.Switch to the second page
        Set<String> allWindows = driver.getWindowHandles();
        for(String eachWindow : allWindows){
            if(!eachWindow.equals(firstPage)){
                driver.switchTo().window(eachWindow);
            }
        }
        String secondPage = driver.getWindowHandle();

        // Type Admin as username and admin123 as password
        driver.findElement(By.id("text")).sendKeys("Admin");
        driver.findElement(By.id("password")).sendKeys("admin123");

        // Click on Login button
        driver.findElement(By.id("login-button")).click();

        // 7. Verify the text that showed up in Popup  is "validation failed"
        String textAlert = driver.switchTo().alert().getText();
        Assert.assertEquals("validation failed", textAlert);

        // 8. Close pop-up by choosing "OK" button
        driver.switchTo().alert().accept();

        // 9. Go back to the previous page
        driver.switchTo().window(secondPage);

        // 10. Verify you are on the first page
        String titleOfFirstPage = driver.getTitle();
        Assert.assertTrue(titleOfFirstPage.contains("WebDriver"));

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

