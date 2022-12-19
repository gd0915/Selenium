package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Practice04 extends TestBase {
    //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    accept Alert(I am an alert box!) and print alert on console
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    cancel Alert  (Press a Button !)
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this message "Hello TechProEducation How are you today"
    //    assert these message
    @Test
    public void test() throws InterruptedException {
//    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

//    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//a[@href='#OKTab']")).click();
        driver.findElement(By.xpath("//*[@id='OKTab']/button")).click();


//    accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

//    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//*[@id='CancelTab']/button")).click();


//    cancel Alert  (Press a Button !)
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

//    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

      Thread.sleep(2000);
//    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

//    finally print on console this message "Hello TechProEducation How are you today"
        WebElement message = driver.findElement(By.id("demo1"));
        Assert.assertTrue(message.isDisplayed());


    }
}
