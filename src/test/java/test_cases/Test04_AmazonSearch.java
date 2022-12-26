package test_cases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;


public class Test04_AmazonSearch extends TestBase {
    /*
    Create a new class: AmazonSearch
       //TC01_As user I want to know how many item are there on amazon in the first page after I search “porcelain teapot”?
       //TC02_Order the tea pot prices, find the min, max, and average price to the nearest cent.
     */

    @Test
    public void amazonSearchTest() throws InterruptedException {
        //User goes to "https://www.amazon.com/"
        driver.get("https://www.amazon.com/");

        Thread.sleep(2000);
        //locate the search box and type “porcelain teapot”
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot" + Keys.ENTER);

        // OR Click to magnifying glass
        //    driver.findElement(By.id("nav-search-submit-button")).click();

        Thread.sleep(2000);
        //See how many result are there on the first page only
        List<WebElement> result = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']"));
        System.out.println("Number of Products on the first page : " + result.size());

        //Order the tea pot prices
        //Locate the dropdown and click
        Thread.sleep(2000);
        WebElement dropdown = driver.findElement(By.cssSelector("#a-autoid-39-announce"));
        dropdown.click();
        //Hover over and select Price low to high
//        Actions actions = new Actions(driver);
//        actions.moveToElement(dropdown).perform();
//        Thread.sleep(1000);
        driver.findElement(By.linkText("Price: Low to High")).click();







    }
}
