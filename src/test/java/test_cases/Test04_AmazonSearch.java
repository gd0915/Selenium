package test_cases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
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
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot" + Keys.ENTER );

        // OR Click to magnifying glass
        //    driver.findElement(By.id("nav-search-submit-button")).click();

        Thread.sleep(2000);
        //See how many result are there on the first page only
        List<WebElement> result = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']"));
        System.out.println("Number of Products on the first page : " + result.size());

        //Order the tea pot prices
        //Locate the dropdown and click
        Thread.sleep(2000);
        WebElement dropdown = driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
        dropdown.click();

        //Order the tea pot prices/ Select Price low to high
        driver.findElement(By.linkText("Price: Low to High")).click();

        //find the min, max, and average price to the nearest cent.
        Thread.sleep(3000);
        List<WebElement> pricesLowToHigh = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        System.out.println("Number of the products ordered from low to high price on the first page: " + pricesLowToHigh.size());

        Thread.sleep(2000);
       List<String> pricesInString = new ArrayList<>();
       for(WebElement w : pricesLowToHigh){
           pricesInString.add(w.getText());
       }
        Thread.sleep(2000);
       List<Double> pricesInDouble = new ArrayList<>();
       for(String w : pricesInString){
           pricesInDouble.add(Double.parseDouble(w));
       }

        Thread.sleep(2000);
        System.out.println("Minimum price : " + pricesInDouble.get(0));
        Thread.sleep(2000);
        System.out.println("Maximum price : " + pricesInDouble.get(pricesLowToHigh.size()-1));

        // Avg price

        double sum =0;
        for(Double w : pricesInDouble){
            sum += w;
        }
        double avgPrice = sum / pricesInDouble.size();
        System.out.println("Average Price : " + avgPrice);

    }
}
