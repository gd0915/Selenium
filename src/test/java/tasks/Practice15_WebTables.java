package tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Practice15_WebTables extends TestBase {
    /*
          1. Go to “https://demoqa.com/webtables”
          2. Print all the department names in Header
          3. Print the Header of the 3rd column
          4. Print all the table data
          5. Print the number of cells  in table
          6. Print the number of rows in table
          7. Print the number of columns in table
          8. Print all the 3rd column data in table
          9. Print the "Salary" of whose "First Name" is "Kierra"
         10. Create a method with 2 parameters(row number and column number) in the class that returns the data of a specific cell
     */

    @Test
    public void test(){
        // 1. Go to “https://demoqa.com/webtables”
        driver.get("https://demoqa.com/webtables");

        //      2. Print all the department names in Header
        List<WebElement> listOfHeaderElements = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));

        for(WebElement eachElement : listOfHeaderElements){
            System.out.println("Header Elements " + eachElement.getText());
        }

        //      3. Print the Header of the 3rd column
        WebElement headerOf3rdColumn = driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]"));
        System.out.println("Header of the 3rd column : " + headerOf3rdColumn);

        //OR
        System.out.println("Header of the 3rd column : " + listOfHeaderElements.get(2).getText());

        //      4. Print all the table data


        //      5. Print the number of cells  in table
        //      6. Print the number of rows in table
        //      7. Print the number of columns in table
        //      8. Print all the 3rd column data in table
        //      9. Print the "Salary" of whose "First Name" is "Kierra"
        //     10. Create a method with 2 parameters(row number and column number) in the class that returns the data of a specific cell


    }



}
