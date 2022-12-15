package tests;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {

    /*
    TEST DATA : username, password, URL, test environment, city, ssn,...
    Where do you get
     */
    @Test
    public void javaFakerTest(){
    //  1.Create the faker object
    Faker faker = new Faker();

    //  2.Now that we have faker object we can generate the fake data
    //  generating username
        String firstName = faker.name().firstName();
        System.out.println(firstName);

    //  generating last name
        String lastName = faker.name().lastName();
        System.out.println(lastName);

    //  generating user name
        String username = faker.name().username();
        System.out.println(username);

    //  generating title
        String title = faker.name().title();
        System.out.println(title);

    //  city
        String city = faker.address().city();
        System.out.println(city);

    //  state
        String state = faker.address().state();
        System.out.println(state);

    //  full address
        String fullAddress = faker.address().fullAddress();
        System.out.println(fullAddress);

    //  cell phone
        String cellPhone = faker.phoneNumber().cellPhone();
        System.out.println(cellPhone);

    //  email
        String email = faker.internet().emailAddress();
        System.out.println(email);

    //  zip code
        String zipCode = faker.address().zipCode();
        System.out.println(zipCode);

    //  random digit number
        String randomDigits = faker.number().digits(10);
        System.out.println(randomDigits);


    }

}
