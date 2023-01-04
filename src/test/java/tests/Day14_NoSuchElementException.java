package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_NoSuchElementException extends TestBase {
    /*
    ===>>>EXCEPTIONS<<<===
    NoSuchElementException
            TimeOutException
    NullPointerException
            InvalidSelectorException
    StaleElementReferenceException
            InvalidElementStateException
    WebDriverException
            ElementNotInteractableException
    ElementClickInterceptedException
            InvalidArgumentException
    JavascriptException
            RemoteDriverServerException
     */

    @Test
    public void noSuchElementException(){
        driver.get("https://www.techproeducation.com");

        // wrong locator
        driver.findElement(By.id("wrong-id")); //NoSuchElementException ==>>org.openqa.selenium.NoSuchElementException:

    }


}
