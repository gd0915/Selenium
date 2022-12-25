package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day10_FileUploadTest extends TestBase {
    /*
    Class Name: FileUploadTest
    Method Name: fileUploadTest
    When user goes to https://the-internet.herokuapp.com/upload
    When user selects an image from the desktop
    And click on the upload button
    Then verify the File Uploaded!  Message displayed
     */

    @Test
    public void fileUploadTest(){
       // user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        // 1.locate choose file and click on choose a file
        //Note: Most of the upload elements are input => type => file.
        //<input  type="file">

        WebElement chooseAFileButton = driver.findElement(By.id("file-upload"));

        // 2. select a file from your computer
        String userHOME=System.getProperty("user.home");
        String pathOfFile = userHOME + "\\Downloads\\logo.jpeg";

        //Sending the path of file that I want to upload
        //We can use sendKeys because of the input type file combination(this is the special case for input type file cases without clicking the button)
        chooseAFileButton.sendKeys(pathOfFile);

        // 3. Then locate and click upload
        driver.findElement(By.id("file-submit")).click();

        // 4. verify the File Uploaded!  Message displayed
        boolean isEqual = driver.findElement(By.xpath("//h3")).getText().equals("File Uploaded!");
        Assert.assertTrue(isEqual);

    }
    /*
    -First selenium has limitation automation of files. But file upload can be done with selenium.
    We locate the choose file button and use sendKeys function to send the path of the file.
    If there is an upload button we click upload button to upload the file.
    (This will automatically upload the file.)
    Path of the file should be dynamic.
     */

    /*
    LIMITATION:
    Selenium has limitation automation DESKTOP APPS
    For example, we can not find path of files, or verify if file exists on out machines with selenum
    Instead we use java File libraries
     */
}
