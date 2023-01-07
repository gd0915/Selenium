package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileDownloadTest extends TestBase {
    /*
    ==>>We can't test windows application with selenium, but we can use JAVA in testing.
    ==>>We can use Java to check if a file exist on our computer or not

        System.getProperty("user.dir"); =>gives the path of the current folder
        System.getProperty("user.home"); =>gives you the user folder
        Files.exists(Paths.get(“path of the file”)); =>Checks if a file path exist on your computer or not

    When we download a file it goes in the 'downloads folder'
    (With selenium we can click on the download button and download a file, but we cannot check if the file exists in our computer)
    We can use this Java concept to check if a downloaded file is in our download folder

     */
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");


//Download b10 all test cases, code.docx
        driver.findElement(By.linkText("b10 all test cases, code.docx")).click();   //downloading the file

//Then verify if the file downloaded successfully
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Downloads\\b10 all test cases, code.docx";

//Then verify if the file downloaded successfully
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);
    }

    @Test
    public void downloadTest2(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

//Download junit-4.13-beta-3.jar file
        driver.findElement(By.linkText("junit-4.13-beta-3.jar")).click();

//Then verify if the file downloaded successfully
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Downloads\\junit-4.13-beta-3.jar";

//Then verify if the file downloaded successfully
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);

    }



}
