package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Practice08_FileUpload extends TestBase {
    /*
    When user goes http://webdriveruniversity.com/File-Upload/index.html
    User selects  a file from the desktop to upload
    Click on the 'Submit' button.
    Then verify the file is uploaded
     */
    @Test
    public void fileUploadTest(){
//      When user goes http://webdriveruniversity.com/File-Upload/index.html
        driver.get("http://webdriveruniversity.com/File-Upload/index.html");

//      Locate the Choose File button
        WebElement chooseFileButton = driver.findElement(By.id("myFile"));

//      User selects  a file from the desktop to upload
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Downloads\\logo.jpeg";

//      Sending path of file
        chooseFileButton.sendKeys(filePath);

//      Click on the 'Submit' button.
        driver.findElement(By.id("submit-button")).click();

//      Switch to alert
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert : " + alertText);

//      Verify the file is uploaded
        Assert.assertEquals("Your file has now been uploaded!", alertText);

//      accept the alert
        driver.switchTo().alert().accept();


    }

}
