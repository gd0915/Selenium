package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    protected static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){

      // driver.quit();
    }

    //    AUTO COMPLETE REUSABLE METHOD
    //    THIS CODE IS USED FOR SELECTING AND VERIFYING OUR APP AUTO COMPLETE SEARCH FUNCTIONALITY
    //    NOTE: THIS REUSABLE METHOD DESIGNED FOR OUR CURRENT PROJECT. THIS MAY NOT WORK FOR NEW PROJECTS, BUT CAN BE MODIFIED AND USED FOR THAT NEW PROJECT
    //    NOTE: YOU WILL SEE THIS KIND OF REUSABLE METHOD THAT IS SPECIFIC TO YOUR OWN PROJECT
    //    THE POINT OF REUSABLE METHOD IS : WRITE ONCE USE MULTIPLE TIMES TO SAVE TIME AND SHORT TEST CLASS
    //    Create a reusable method takes care of the repetitions
    public static void searchAndSelectFromList(String keyword, String textFromList) throws InterruptedException {
        // searchAndSelectFromList("uni", "United Kingdom");
        Thread.sleep(2000);//putting wait to see steps slower
        //Sending a KEYWORD DYNAMICALLY using PARAMETER 1
        driver.findElement(By.id("myCountry")).sendKeys(keyword);//uni
        Thread.sleep(2000);
        //Selecting an option from the list DYNAMICALLY using PARAMETER 2
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='"+textFromList+"']")).click();
        Thread.sleep(2000);
        //Nothing special. Just clicking on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();//click on submit button
        Thread.sleep(2000);
        //Verifying if result contains the option that I selected DYNAMICALLY using PARAMETER 2
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains(textFromList));
    }

    // TAKE A SCREENSHOT OF ENTIRE PAGE WITH THIS REUSABLE METHOD
    public void takeScreenshotOfPage() throws IOException {
        // 1.Take screenshot using getScreenShotAs() method and TakeScreenshot API-coming from Selenium
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);// ===>>>We are using OutputType.FILE because screenshots are a file at the end of the day

        // 2. Creating a PATH with dynamic name for the image
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); //getting  current local date and time with this format

        //path is where we save the screenshot. PROJECT/ FOLDER(test-output)    / FOLDER     / NAME OF IMAGE   .png(images extension) /
        String path = System.getProperty("user.dir")+ "/test-output/Screenshots/"+currentTime+"image.png"; //Where we save the image
                        //This is the project           //Folder name          //Current time

        //3. Saving the IMAGE in the PATH
        FileUtils.copyFile(image,new File(path)); //We copy the image in to the path in the second parameter
    }

    // TAKE A SCREENSHOT OF SPECIFIC ELEMENT
    public void takeScreenshotOfTheElement(WebElement element) throws IOException {
        // 1.Take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);

        // 2. Creating a PATH with dynamic name for the image
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); //getting  current local date and time with this format

        //path is where we save the screenshot. PROJECT/ FOLDER(test-output)    / FOLDER     / NAME OF IMAGE   .png(images extension) /
        String path = System.getProperty("user.dir")+ "/test-output/Screenshots/"+currentTime+"image.png";//Where we save the image
        //This is the project               //Folder name          //Current time

        //3. Saving the IMAGE in the PATH
        FileUtils.copyFile(image,new File(path));

    }


}
/*!!!
As a Tester What am I doing?
1. Create manual and automation test cases
2. Prepare test reports
    a. Test Execution and Capture screenshots
    b. Report bugs when and bug is found. Takes screenshot of the bug steps
3. Run smoke tests and check results. Communicate with the team if any test fails.
4. Run regression tests etc.

 */
