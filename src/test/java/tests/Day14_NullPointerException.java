package tests;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Day14_NullPointerException {

    //DECLARED BUT NEVER INSTANTIATED
    WebDriver driver;
    Faker faker;
    @Test
    public void nullPointerExceptionTest(){
        driver.get("https://www.techproeducation.com"); //NullPointerException

        }
    @Test
    public void nullPointerExceptionTest1(){
            System.out.println(faker.name().fullName());//NullPointerException
        }




}
