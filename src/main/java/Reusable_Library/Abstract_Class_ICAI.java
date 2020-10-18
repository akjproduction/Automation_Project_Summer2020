package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import jxl.read.biff.BiffException;

import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_Class_ICAI {

    //declare all the global variables outside of the methods
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void setPrecondition() throws IOException, BiffException {
        //set the driver here
        driver = Reusable_Methods_Loggers.getDriver();
        //set the report path here
        reports = new ExtentReports("src/main/java/HTML_Report/InClassActionItemReport.html",true);

    }//end of before suite

    //to be able to pick up the name of your test classes dynamically we need to use before method
    @BeforeMethod
    public void captureTestName(Method methodName){
        logger = reports.startTest(methodName.getName());
    }//end of before method

    @AfterMethod
    public void endTest(){
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void endSession() throws IOException, WriteException, InterruptedException {

        reports.flush();
        Thread.sleep(2000);
        driver.quit();
    }//end of afterSuite

}//end of abstract class
