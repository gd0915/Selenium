package tests;

import org.junit.Test;
import utilities.TestBase;

public class Day08_Authentication extends TestBase {

    @Test
    public void authTest(){
        /*
            url      : the-internet.herokuapp.com/basic_auth
            username : admin
            password : admin

            GO LINK   : https://username:pass@url
         */

        //this will do authentication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
