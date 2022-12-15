package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_WebDriverManager {
    public static void main(String[] args) {
        // System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        //We no longer need to use System.setProperty. We can use WebDriverManager API(alternative way for setting up the web-driver)
        WebDriverManager.chromedriver().setup();

        //REST IS THE SAME
        //Create Driver
        WebDriver driver = new ChromeDriver();//WebDriver is an interface , and uses the constructor from ChromeDriver class
        //maximize the page
        driver.manage().window().maximize();
        //going to the page
        driver.get("https://techproeducation.com/");
        //close
        driver.quit();


    }
    /*
    So far we used drivers in our local
    We can use WebDriverManager dependency on a maven project
    This helps us to 'set-up' and use driver faster
    This is the second way of using driver
    From now on we will use WebDriverManager
    For this, we go to mvnrepository.com and get the WebDriverManager
    dependency
    https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
     */
}
