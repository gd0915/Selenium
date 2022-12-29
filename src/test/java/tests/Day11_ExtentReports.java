package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day11_ExtentReports extends TestBase {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    //protected static ExtentTest logger; //We can also use logger instead of extentTest but we prefer extentTest

    @BeforeClass
    public static void extentReportsSetUp(){

//        REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

//        ***************
//        adding custom System Info(with extentReports obj)
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechProEd");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team","Eagles");
        extentReports.setSystemInfo("SQA","John Fox");
        extentReports.setSystemInfo("Sprint Number", "SP206"); //adding Sprint Number

//        adding more custom info (with extentHtmlReporter)
        extentHtmlReporter.config().setReportName("TechProEd home page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");

//        ********************
//        DONE WITH CONFIGURATION
        extentReports.attachReporter(extentHtmlReporter); //create the report
//        SUMMARY : Extent Reports and Extent HTML Reporter is used to add custom information on the report and create the report in a PATH

//        REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE
//        Creating extent test
        extentTest= extentReports.createTest("My Extent Reporter","Regression Test Report");

    }

    //1. Extent reports is used for generating CUSTOM HTML REPORTS
    //2. We can add company or project specific information in the report configuration

    @Test
    public void extentReportsTest(){
        extentTest.pass("Going to the App home page");
        driver.get("https://www.techproeducation.com");
       // OR
       // extentTest.pass("User is on TechProEducation Home Page");

//      click on LMS
        extentTest.pass("Clicking on LMS Login button");
        driver.findElement(By.linkText("LMS LOGIN")).click();
       // OR
       // extentTest.pass("User is on LMS home page");

//      verify URL
        extentTest.pass("Verify the LMS Url");
        String expectedURL = "https://lms.techproeducation.com/";
        String actualURL = driver.getCurrentUrl();
        // OR
        //extentTest.pass("Asserting the LMS Url");
        Assert.assertEquals("LMS Login page is not displayed",expectedURL, actualURL);
        extentTest.pass("Test is complete");

    }

    @AfterClass
    public static void extentReportsTearDown(){
        // generating the report
        extentReports.flush();
    }




}

/*
https://www.extentreports.com/docs/versions/4/java/index.html
 */

/*
We downloaded extent reports dependency from Maven.
 */
