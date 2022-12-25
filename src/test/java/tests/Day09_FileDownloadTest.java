package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileDownloadTest extends TestBase {
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
