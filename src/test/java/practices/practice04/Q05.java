package practices.practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Q05 extends TestBase {
    /*
    Given
        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    When
        Fill the username, password and textArea comment:
    And
        Choose a file and upload it
    And
        Select checkbox, radio item and dropdowns
    And
        Click on submit
    Then
        Verify that uploaded file name is on the Form Details.
     */
    @Test
    public void test(){
        //  Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        //    Fill the username, password and textArea comment:
        driver.findElement(By.name("username")).sendKeys("JohnDoe");
        driver.findElement(By.name("password")).sendKeys("123456");
        WebElement textArea = driver.findElement(By.name("comments"));
        textArea.sendKeys(Keys.CLEAR + "Hello I am a comment");

        //    Choose a file and upload it
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Downloads\\textfile.txt";
        driver.findElement(By.name("filename")).sendKeys(filePath);

        //    Select all checkboxes, radio item and dropdowns
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[2]"));
        WebElement checkBox3 = driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[3]"));
        if(!checkBox1.isSelected()){
           checkBox1.click();
        }
        if(!checkBox2.isSelected()){
            checkBox2.click();
        }
        if(!checkBox2.isSelected()){
            checkBox2.click();
        }

        driver.findElement(By.xpath("//input[@value='rd1']")).click();//Radio Button 1

        WebElement dropdown = driver.findElement(By.xpath("//select[@multiple='multiple']"));
        Select select=new Select(dropdown);
        select.deselectAll();
        driver.findElement(By.xpath("//option[@value='ms1']")).click();//Option 1
        //select.selectByIndex(0);
        //dropdown.sendKeys(Keys.SHIFT);
        //select.selectByIndex(1);//Option 2

        //Click on submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

        // Verify that uploaded file name is on the Form Details.
        //1st way
        String message = driver.findElement(By.xpath("//div[@class='explanation']//p")).getText();
        Assert.assertTrue(message.contains("You submitted a form."));

        //2nd way
        String fileName = driver.findElement(By.id("_valuefilename")).getText();
        Assert.assertEquals("textfile.txt",fileName);
    }
}
