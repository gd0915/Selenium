package tests;

import org.junit.Assert;
import org.junit.Test;

public class Day03_Assertions {
    @Test
    public void assertions(){


        /*
        What is assertion in testing?
        Assertion is done to check expected result is equal to actual result.
        -expected == actual => pass
        -expected != actual -> fail
        ----------------------
        assertEquals("expected", "actual");
        assertTrue(true); -> pass
        assertTrue(false); -> fail
        assertFalse(false); -> pass
        assertFalse(true); -> fail
         */

        Assert.assertEquals(5,5);//PASS

        if("java".contains("apple")){  //FAIL
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Assert.assertEquals("java".contains("j"), true);//PASS
//      ----------------------
        Assert.assertTrue("java".contains("j")); //this assertion expect a true value --> PASS
//      ----------------------
        Assert.assertFalse("Java".contains("j")); //this statement expect a false value -->PASS
//      TEST EXECUTION STOPS IF ONE STATEMENT FAILS THIS IS CALLED HARD ASSERTION

//      TEST EXECUTION CONTINUE EVEN IF TEST VERIFICATION FAILS. VERIFICATION MEANS LIKE IF STATEMENT.

//      What is the difference between assertion and verification?
//      Assertion stops after assertion fails. Verification continues even after verification fails
//      JUnit assertions are hard assertion. If statement is verification.
//      NOTE: TestNG has soft assertion as well. We will learn it in TestNG.


        /*INTERVIEW QUESTION!!
        There are 8 selenium locators to locate an element.
        id
        name
        className
        tagName
        linkText
        partialLinkText
        xpath    ->There are multiple ways to write xpath
        css      ->There are multiple ways to write css
         */

    }

}
