package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day08_Authentication extends TestBase {

    @Test
    public void authTest(){
        /*
            url      : the-internet.herokuapp.com/basic_auth
            username : admin
            password : admin
            SPECIAL URL FOR AUTHENTICATION
            GO LINK   : https://username:pass@url
         */

        //this will do authentication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String successMessage = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(successMessage.contains("Congratulations! You must have the proper credentials."));
    }
}
