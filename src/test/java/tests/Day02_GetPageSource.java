package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class Day02_GetPageSource {
    /*
    //getPageSource() returns page source code as a string
    //We might use this to verify if a certain text exist in the entire page
    //Note that pageSource is not used a lot to do assertions
    //Because it is too general and can lead false result
    TEST CASE:
    Test if amazon contains “Registry” on the homepage
    Create a new class : GetPageSource
     */

    public static void main(String[] args) {
        //Set up web driver
        WebDriverManager.chromedriver().setup();
        //Create Driver
        WebDriver driver = new ChromeDriver();
        //maximize the page
        driver.manage().window().maximize();
        //going to the page
        driver.get("https://www.amazon.com/");
        //verify if amazon contains “Registry” on the homepage
        String pageSource = driver.getPageSource();
        //System.out.println(pageSource);//(not recommended to print page source here!)
        String expectedWord = "Registry";

        if(pageSource.contains(expectedWord)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("PAGE SOURCE : " + pageSource);
            System.out.println("EXPECTED WORD : "+ expectedWord);
        }
        driver.quit();

    }
}
/*
Added jUnit dependency
-Most basic Java testing framework
-JUnit is an API to create testing framework; it is not a library

 */
