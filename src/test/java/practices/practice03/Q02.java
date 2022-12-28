package practices.practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q02 extends TestBase {
    /*
    Given
        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
    When
       Type "My File" into "Notes about the file" input
    And
        Select the file to upload
    And
        Click "Choose File" button
    And
        Click on "Press" button
    Then
        Assert that "Your notes on the file were" equals "My File"
    And
        Assert that file Content contains "Hello, I am uploaded file"
     */

    @Test
    public void test(){
        //Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        //Type "My File" into "Notes about the file" input
        driver.findElement(By.xpath("//input[@name='note']")).sendKeys("My File");
        WebElement chooseFile = driver.findElement(By.xpath("//input[@name='upfile']"));

        String filePath = System.getProperty("user.home") + "\\Downloads\\text.txt";

        chooseFile.sendKeys(filePath);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Assert that "Your notes on the file were" equals "My File"
        WebElement note = driver.findElement(By.xpath("//blockquote"));   //or "//blockquote"
        Assert.assertEquals("My File", note.getText());
        System.out.println("1");

        WebElement content = driver.findElement(By.xpath("//pre"));
        Assert.assertEquals("\"Hello, I am uploaded file\"", content.getText());

    }
}
