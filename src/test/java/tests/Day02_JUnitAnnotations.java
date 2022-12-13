package tests;

import org.junit.*;

public class Day02_JUnitAnnotations {
    /*
    * So far we kept usign main method
    * We no londer need to use main method to create a test cases with JUnit
    * -@Test  : is used to create test cases
    * NOTE : All @Test methods must be void
    * -@Before: Runs before each @test class. This is used to run repeated pre-conditions.
    * For example, setup driver, create driver, maximize window
    * -@After: Runs after each @test class
    * For example, driver quit, report generation
    * -@BeforeClass: Runs before each CLASS only ONCE. This method must be static. (otherwise we get RunTimeException)
    * -@AfterClass: Runs after each CLASS only ONCE. This method must be static. (otherwise we get RunTimeException)
     */

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class Runs before the entire class");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class Runs after the entire class");
    }
    @Before
    public void setUp(){
        System.out.println("Before Method runs before each @Test annotation");
    }
    @After
    public void tearDown(){
        System.out.println("After Method runs after each @Test annotation");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test @Ignore //From JUnit
    public void test3(){
        System.out.println("Test 3");
    }
    @Test
    public void test4(){
        System.out.println("Test 4");
    }
    @Test
    public void test5(){
        System.out.println("Test 5");
    }
}
