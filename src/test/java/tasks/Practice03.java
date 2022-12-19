package tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Practice03 extends TestBase {
    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    // -->Task1 Find Dropdown on Multi Selection
    // -->Task2 Find  all Dropdown Elements on page
    // -->Task3 printout DropDown Elements' number
    // -->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6

    @Test
    public void tes(){
        // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        //Find Dropdown on Multi Selection
        driver.findElement(By.id("justAnInputBox")).click();

        //Find  all Dropdown Elements on page
       List<WebElement> options = driver.findElements(By.xpath("//span[@class ='comboTreeItemTitle']"));

        //printout DropDown Elements' number
        System.out.println("Number of the dropdown options : " +  options.size());

        //choose dropdown elements and printout dropdown elements' name  until choise 6
        for(int i =0; i<options.size(); i++){
            System.out.println(options.get(i).getText());

            if(options.get(i).getText().equals("choice 6")){
                options.get(i).click();
                break;
            }
        }


    }
}
