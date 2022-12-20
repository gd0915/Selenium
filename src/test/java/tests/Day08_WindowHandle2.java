package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.text.AttributedString;

public class Day08_WindowHandle2 extends TestBase {
    //Open 3 new windows and verify their URLS
    //Open 3 new tabs and verify their URLS

    @Test
    public void newWindowTest() throws InterruptedException {
    //  open techproeducation
    driver.get("https://techproeducation.com/");
    String techProTitle = driver.getTitle();
    Assert.assertTrue(techProTitle.contains("Techpro Education"));
    String techProHandle = driver.getWindowHandle();

    //  open amazon
    Thread.sleep(5000);
    driver.switchTo().newWindow(WindowType.WINDOW);//create a new window and switches to that window automatically
    driver.get("https://www.amazon.com");
    String amazonTitle = driver.getTitle();
    Assert.assertTrue(amazonTitle.contains("Amazon"));
    String amazonHandle = driver.getWindowHandle();//getting window 2 id

    //  open linkedin
    Thread.sleep(5000);
    driver.switchTo().newWindow(WindowType.WINDOW);//create a new window and switches to that window automatically
    driver.get("https://www.linkedin.com");
    String linkedinTitle = driver.getTitle();
    Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
    String linkedinHandle = driver.getWindowHandle();//getting window 3 id

    //Switch back to TechPro
    Thread.sleep(3000);
    driver.switchTo().window(techProHandle);
    System.out.println("TechPro : " + driver.getCurrentUrl());

     //Switch back to Amazon
    Thread.sleep(3000);
    driver.switchTo().window(amazonHandle);
    System.out.println("Amazon : " + driver.getCurrentUrl());

    //Switching back to Linkedin
    Thread.sleep(3000);
    driver.switchTo().window(linkedinHandle);
    System.out.println("LinkedIn : " + driver.getCurrentUrl());
    }

    @Test
    public void newTabTest() throws InterruptedException {
        //  open techproeducation on TAB 1
        driver.get("https://techproeducation.com/");
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();

        //  open amazon on a new window 2-TAB
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);//create a new window and switches to that window automatically
        driver.get("https://www.amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();//getting window 2 id

        //  open linkedin on a new window 3-TAB
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);//create a new window and switches to that window automatically
        driver.get("https://www.linkedin.com");
        String linkedinTitle = driver.getTitle();
        Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();//getting window 3 id

        //Switch back to TechPro
        Thread.sleep(3000);
        driver.switchTo().window(techProHandle);
        System.out.println("TechPro : " + driver.getCurrentUrl());

        //Switch back to Amazon
        Thread.sleep(3000);
        driver.switchTo().window(amazonHandle);
        System.out.println("Amazon : " + driver.getCurrentUrl());

        //Switching back to Linkedin
        Thread.sleep(3000);
        driver.switchTo().window(linkedinHandle);
        System.out.println("LinkedIn : " + driver.getCurrentUrl());
    }
}
