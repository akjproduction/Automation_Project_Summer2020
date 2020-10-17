package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_Class_AI {
    //declare all the global variables outside of the methods
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;
    public static Workbook readableFile;
    public static Sheet readableSheet;
    public static WritableWorkbook writableFile;
    public static WritableSheet writableSheet;
    public static int rowCount;

    @BeforeSuite
    public void setPrecondition() throws IOException, BiffException {
        //set the driver here
        driver = Reusable_Methods_Loggers.getDriver();
        //set the report path here
        reports = new ExtentReports("src/main/java/HTML_Report/ActionItemReport.html",true);
        //locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Express_AI.xls"));
        //locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Express_AI_Results.xls"), readableFile);
        //define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();
        System.out.println("Mohammed Forkan _ Action Item 7");

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

        writableFile.write();
        writableFile.close();
        reports.flush();
        Thread.sleep(2000);
        driver.quit();
    }//end of afterSuite

}//end of abstract class
