package practices.practice06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.DecimalFormat;
import java.util.List;

public class Q02 extends TestBase {
    /*
    /We will make a roof of 5% of the height of the earliest built tower.
    //Find how many meters we will build.
     */
    /*
     Given
        Go to https://www.techlistic.com/p/demo-selenium-practice.html
    When
        Put all built years into a list
    And
        Calculate min year
    And
        Put all heights into a list
    And
        Calculate the height to build
    Then
        Assert that build height is 25.45 meters
     */

    @Test
    public void test(){
//        Go to https://www.techlistic.com/p/demo-selenium-practice.html
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

//        Put all built years into a list
        List<WebElement> builtYears = driver.findElements(By.xpath("(//tbody)[2]/tr/td[4]"));


//        Calculate min year
        int minYear = Integer.parseInt(builtYears.get(0).getText());
        for (WebElement w : builtYears){

            if(Integer.parseInt(w.getText())<minYear){
                minYear = Integer.parseInt(w.getText());
            }

        }
        System.out.println("minYear = " + minYear);//2004

//        Find index of min year

        int idxOfMinYear=0;
        for(int i=0; i< builtYears.size(); i++){

            if(Integer.parseInt(builtYears.get(i).getText())==minYear){
                idxOfMinYear=i;
            }
        }
        System.out.println("idxOfMinYear = " + idxOfMinYear);

        //        Put all heights into a list
        List<WebElement> heights = driver.findElements(By.xpath("(//tbody)[2]/tr/td[3]"));

        //        Calculate the height to build
        double heightToBuild = Integer.parseInt(heights.get(idxOfMinYear).getText().replaceAll("\\D", ""))*0.05;
        System.out.println("heights.get(idxOfMinYear) = " + heights.get(idxOfMinYear));

        //        Calculate the total height
        int totalHeight=0;
        for(WebElement w : heights){
           totalHeight += Integer.parseInt(w.getText().toString().substring(0,3));
        }
        System.out.println("Total height : " + totalHeight); //2431


        //        Assert that build height is 25.45 meters
        System.out.println("heightToBuild = " + heightToBuild);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedHeight = decimalFormat.format(heightToBuild);
        System.out.println("You will build: " + formattedHeight + " meters");

    }
}
