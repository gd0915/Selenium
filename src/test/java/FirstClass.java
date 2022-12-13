import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) {

        //1. Set up Chrome Driver
        //First parameter is "Driver" and the second parameter is the path of "Driver"
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");

        //2. Create Chrome Driver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.techproeducation.com");
        //We use get() method to go to a webpage

        /*
        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.get("url");              //Navigate to the page

        driver.getTitle();              //Returns the title of the page  //Title in browser.

        driver.getCurrentUrl();         //Returns the URL of the page

        driver.getPageSource();         //Returns the page source of the page  //right click on page-->view page source

        driver.getWindowHandle();       //Returns the unique ID of the active window

        driver.getWindowHandles();      //Returns the unique ID of the all active windows

        driver.navigate().to("url");     //Navigate to the page

        driver.manage().window().maximize();    //Maximizes the window
         */

        /*
        <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.3.1</version>
        </dependency>

        "This dependency is used for creating web driver"!

         */

    }
}
