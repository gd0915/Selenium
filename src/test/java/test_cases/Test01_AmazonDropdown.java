package test_cases;

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

public class Test01_AmazonDropdown {
//    Create A Class: AmazonDropdown
//    Create A Method dropdownTest
//    Go to https://www.amazon.com/
//    Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
//    Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
//    Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
//          (after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
//    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
//    Print the the total number of options in the dropdown
//    Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
//    BONUS: Assert if the dropdown is in Alphabetical Order

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void dropdownTest(){
       // Find the element of the dropdown element.
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);

        //Print the first selected option and assert if it equals “All Departments”.If it fails,
        // then comment that code out and continue rest of the test case.
        String firstSelectedOption = select.getFirstSelectedOption().getText();
        System.out.println("First selected option is : " + firstSelectedOption);
        Assert.assertEquals("All Departments", firstSelectedOption );

        //Select the 4th option by index (index of 3) and assert if the name is “Baby”.
        //  (after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        select.selectByIndex(3);
        String optionFour = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Baby", optionFour);

        //Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> options = select.getOptions();
        for(WebElement eachOption : options){
            System.out.println(eachOption.getText());
        }

        //Print the total number of options in the dropdown
        int numOfOptions = options.size();
        System.out.println("Number of the all options : " + numOfOptions);

        //Assert if ‘Books’ is a dropdown option. Print true if “Books” is an option. Print false otherwise.
        boolean isBooksExists = false;

        for(WebElement eachOption : options){
            if(eachOption.getText().equals("Books")){
                isBooksExists=true;
            }
         }
        System.out.println(isBooksExists);
        Assert.assertTrue(isBooksExists);

       // BONUS: Assert if the dropdown is in Alphabetical Order
        boolean isInAscendingOrder=false;
        String previous="";
        for(WebElement eachOption : options){
            if(eachOption.getText().compareTo(previous)>0){
                isInAscendingOrder=true;
            }
            previous=eachOption.getText();
        }
        Assert.assertTrue(isInAscendingOrder);

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
