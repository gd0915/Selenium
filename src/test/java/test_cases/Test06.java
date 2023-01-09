package test_cases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Test06 extends TestBase {
    /*
    When user goes to https://jqueryui.com/datepicker/
    And select the next date of the current date
    EG if today is August 30, 2022 -> select August 31, 2022
     */

    @Test
    public void test06() {
        // When user goes to https://jqueryui.com/datepicker/
        driver.get("https://jqueryui.com/datepicker/");

        // Select the next date of the current date
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();

        List<WebElement> allTableElements = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']"));
        System.out.println(allTableElements.size());

        //1st way:
        String currentDate = new SimpleDateFormat("d").format(new Date());
        System.out.println(currentDate);

        for(int i =0; i<allTableElements.size();i++){
            if(allTableElements.get(i).getText().equals(currentDate)){
                allTableElements.get(i+1).click();
            }
        }

        //2nd way:

        WebElement date = driver.findElement(By.id("datepicker"));
        Actions actions = new Actions(driver);
        actions.click(date);
        LocalDate currentDate1 = LocalDate.now();
        System.out.println(currentDate);

        String nextDate = currentDate1.plusDays(1).toString();
        date.sendKeys(nextDate);


    }

}
