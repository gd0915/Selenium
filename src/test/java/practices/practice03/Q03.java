package practices.practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q03 extends TestBase {
    /*
    Given
        Go to http://the-internet.herokuapp.com/add_remove_elements/
    When
        Click on the "Add Element" button 100 times
    And
        Click on the "Delete" button 20 times
    Then
        Assert that 20 buttons were deleted.
        */
     @Test
    public void test(){
         //  Go to http://the-internet.herokuapp.com/add_remove_elements/
         driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

         //Click on the "Add Element" button 100 times
         WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
         for(int i =0; i<100; i++){
             addButton.click();
         }

         //Click on the "Delete" button 20 times
         List<WebElement> deleteButtonList = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
         System.out.println("Delete Buttons before delete : " + deleteButtonList.size());
         for(int i =0; i<20; i++){
             deleteButtonList.get(i).click();
         }
         List<WebElement> deleteButtonListAfterDelete = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
         System.out.println("Delete Buttons after delete : " + deleteButtonListAfterDelete.size());

         //Assert that 20 buttons were deleted.
         Assert.assertEquals(deleteButtonList.size()-20, deleteButtonListAfterDelete.size());

     }
}
