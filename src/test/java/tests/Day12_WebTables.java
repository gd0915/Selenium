package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Day12_WebTables extends TestBase {
    /*
    https://the-internet.herokuapp.com/tables
    Create a class: WebTables
    Task 1 : Print the entire table
    Task 2 : Print All Rows
    Task 3 : Print Last row data only
    Task 4 : Print column 5 data in the table body
    Task 5 : Write a method that accepts 2 parameters
    Parameter 1 = row number
    Parameter 2 = column number
    printData(2,3);  => prints data in 2nd row 3rd column
     */

    @Test
    public void printTableData(){
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Print the entire table
        System.out.println("PRINT ENTIRE TABLE***");
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(entireTable);

        List<WebElement> allTableElements = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachElement : allTableElements){
            System.out.println(eachElement.getText());
        }
    }

    @Test
    public void printAllRows(){
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 2 : Print All Rows
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        int rowNum=1;
        for(WebElement eachRow:allRows){
            System.out.println("Row " + rowNum + " => " + eachRow.getText());
            rowNum++;
        }
        //We can get specific row data
        System.out.println("4th Row Data : " + allRows.get(4).getText());

        //    Task 3 : Print Last row data only
        System.out.println("Last Row Data : " + allRows.get(allRows.size()-1).getText());

    }

    @Test
    public void printColumns(){
        driver.get("https://the-internet.herokuapp.com/tables");
        //    Task 4 : Print column 5 data in the table body
        List<WebElement> col5Data = driver.findElements(By.xpath("//table[@id='table1']//td[5]"));
        int colNum= 1;
        for(WebElement eachData : col5Data){
            System.out.println("Row " + colNum + " Column 5 => " + eachData.getText());
            colNum++;
        }
    }

    //    Task 5 : Write a method that accepts 2 parameters
    //    Parameter 1 = row number
    //    Parameter 2 = column number
    //    printData(2,3);  => prints data in 2nd row 3rd column
    public void printData(String url , int rowNum, int colNum){
        driver.get(url);
        String xpath = "//table[@id='table1']//tr["+rowNum+"]//td["+colNum+"]";
        WebElement data = driver.findElement(By.xpath(xpath));
        System.out.println("Row " + rowNum + " Column " + colNum +  "  => " + data.getText());
    }

    @Test
    public void printDataTest(){
        printData("https://the-internet.herokuapp.com/tables",2,3);//fbach@yahoo.com
        printData("https://the-internet.herokuapp.com/tables", 4,1);//Conway
    }




}
