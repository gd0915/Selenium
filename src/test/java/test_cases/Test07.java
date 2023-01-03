package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Test07 extends TestBase {
    /*
    When user goes to https://jqueryui.com/toggle/
    Print the text that should be :
    Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    Eg: System.out.println(element);
    -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    Then click on Run Effect button
    Then print the text and verify it is empty.
    Eg: System.out.println(element); -> NO TEXT
    Then click on Run Effect button one more time
    Print the text that should be :
    Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    Eg: System.out.println(element);
    -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    You can use hard wait if needed.
     */

    @Test
    public void test() throws InterruptedException {
       // User goes to https://jqueryui.com/toggle/
       driver.get("https://jqueryui.com/toggle/");

       // Print the text
       driver.switchTo().frame(0);
       String text = driver.findElement(By.xpath("//*[@id='effect']/p")).getText();
       System.out.println(text);

       // Then click on Run Effect button
        driver.findElement(By.id("button")).click();

       // Then print the text and verify it is empty.
        Thread.sleep(2000);
        String text1 = driver.findElement(By.xpath("//*[@id='effect']/p")).getText();
        System.out.println(text1);
        Assert.assertTrue(text1.isEmpty());

        // Then click on Run Effect button
        driver.findElement(By.id("button")).click();

        // Then click on Run Effect button one more time
        //    Print the text oe more time
        Thread.sleep(2000);
        String text2 = driver.findElement(By.xpath("//*[@id='effect']/p")).getText();
        System.out.println(text2);


    }

}
