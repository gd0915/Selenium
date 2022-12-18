package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Day05_Dropdown {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest(){

        //1.Select Option 1 by index from the dropdown
        //      1.locate the dropdown
            WebElement dropdown = driver.findElement(By.id("dropdown"));

        //      2. Create Select object cause dropdown is in the select tag. This is for only dropdowns.
            Select select = new Select(dropdown);

        //      3. Select any option using the select object
            select.selectByIndex(1);//index starts at 0
    }

    @Test
    public void selectByVisibleText(){
        //2.Create method selectByValueTest Select Option 2 by visible text
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");

    }

    @Test
    public void selectByValue() throws InterruptedException {
        //3.Create method selectByValueTest Select Option 1 by value
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(3000);//HARD WAIT. WAITS 3 SECONDS.
        select.selectByValue("1");
        select.selectByValue("2");
        select.selectByValue("1");
        select.selectByValue("2");
    }

    //4.Create method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
//        getOptions(); returns all of the dropdown options
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions){
//            getText() returns the TEXT of the webelements as STRING
            System.out.println(eachOption.getText());
        }
//    5. Verify the dropdown has Option 2 text
        boolean isOption2Exist=false;
        for (WebElement eachOption : allOptions){
            if (eachOption.getText().equals("Option 2")){
                isOption2Exist=true;
            }
        }
//        fails if Option 2 is not in the dropdown
//        pass if Option 2 is in the dropdown
        Assert.assertTrue(isOption2Exist);
    }

    //6.Create method printFirstSelectedOptionTest Print first selected option
    @Test
    public void printFirstSelectedOptionTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
//        printing the selected option
        System.out.println("Selected Option : "+select.getFirstSelectedOption().getText());
//        selecting a different option from the dropdown
        select.selectByIndex(2);
//        printing the selected option
        System.out.println("Selected Option : "+select.getFirstSelectedOption().getText());

//    7.Find the size of the dropdown,
//        Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        int numberOfOptions = select.getOptions().size();
        int expectedNumberOfOptions = 3;
//        Assertion will print Expected Is Not Equal Actual ONLY IF THIS ASSERTION FAILS
        Assert.assertEquals("Expected Is Not Equal Actual",expectedNumberOfOptions,numberOfOptions);
    }


    @After
    public void tearDown(){
        // Close the browser by using @After annotation
        driver.quit();
    }




//7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
}
