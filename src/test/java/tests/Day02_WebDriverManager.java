package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_WebDriverManager {
    public static void main(String[] args) {
        // System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        //We no longer need to use System.setProperty. We can use WebDriverManager API(alternative way for setting up the webdriver
        WebDriverManager.chromedriver().setup();

        //REST IS THE SAME
        //Create Driver
        WebDriver driver = new ChromeDriver();
        //maximize the page
        driver.manage().window().maximize();
        //going to the page
        driver.get("https://techproeducation.com/");
        //close
        driver.quit();


    }
}
