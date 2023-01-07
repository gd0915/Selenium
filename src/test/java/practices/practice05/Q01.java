package practices.practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q01 extends TestBase {

    /*
    Given
           Go to https://testpages.herokuapp.com/styled/tag/table.html
    When
           Calculate the total amount on the table
    Then
            Assert the amount
     */

    @Test
    public void test(){

        // Go to https://testpages.herokuapp.com/styled/tag/table.html
        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");

        // Calculate the total amount on the table
        List<WebElement> prices = driver.findElements(By.xpath("//table[@id='mytable']//td[2]"));
        List<WebElement> prices2 = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        double sum = 0;
        for(WebElement eachPrice : prices){
            sum += Double.valueOf(eachPrice.getText());
            //sum += Double.parseDouble(eachPrice.getText());
        }
        System.out.println(sum);

        //Assert the amount
        Assert.assertTrue(sum==110.3);
    }



}
