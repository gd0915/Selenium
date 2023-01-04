package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_TimeOutException extends TestBase {

    @Test
    public void timeOutExceptionTest(){
        driver.get("https://www.techproeducation.com");
        // Trying to locate element using explicit wait
        // We get TomeOutException because explicit wait could not handle the issue
        waitForVisibility(By.id("wrong-id"), 15); //org.openqa.selenium.TimeoutException:



    }
}
