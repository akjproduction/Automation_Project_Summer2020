package Action_Items;

import Reusable_Library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment_6B {
    //declare all the global variables outside
    WebDriver driver = null;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    @BeforeSuite
    public void setDriver() throws IOException, BiffException {
//setting the chrome driver
    driver = Reusable_Methods.getDriver();
    //locate the readable excel workbook
    readableFile = Workbook.getWorkbook(new File("src/main/resources/ActionItem_Kayak.xls"));
    //locate the excel sheet for this readable workbook
    readableSheet = readableFile.getSheet(0);
    //make a copy of readable file to write back to the excel so it doesn't corrupt the original file
    writableFile = Workbook.createWorkbook(new File("src/main/resources/ActionItem_Kayak_Results.xls"), readableFile);
    //define the writable sheet for writable file
    writableSheet = writableFile.getSheet(0);
    //get the count of the rows that are not empty on your excel workbook
    rowCount = writableSheet.getRows();
}//end of before suite

    @Test
    public void getKayakResults() throws InterruptedException, WriteException {
        //all the test steps have to go inside for loop
        for (int i = 1; i < rowCount; i++) {
            //get the content of the cell
            //column is hard coded and row is dynamic(i)
            String Airport = writableSheet.getCell(0,i).getContents();
            String StartDate = writableSheet.getCell(1,i).getContents();
            String EndDate = writableSheet.getCell(2,i).getContents();
            String StartTime = writableSheet.getCell(3,i).getContents();
            String EndTime = writableSheet.getCell(4,i).getContents();
            String VehicleSize = writableSheet.getCell(5,i).getContents();

            driver.manage().deleteAllCookies();// delete all cookies before navigating
            //navigate to Kayak.com
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(2000);
            //Capture Title
            Reusable_Methods.checkTitle(driver,"https://www.kayak.com","KAYAK");
            //airport
            Reusable_Methods.click(driver,"//*[contains(@id,'pickup-display')]", "Search");
            Thread.sleep(1000);
            Reusable_Methods.typeAndSubmit(driver,"//*[@name='pickup']",Airport,"Airport");
            //Reusable_Methods.click(driver,"//*[@class='compare-to']","Blank Field");
            //enter start date
            Reusable_Methods.click(driver,"//*[@aria-label='Pick-up date']","Start Date");
            Thread.sleep(500);
            Reusable_Methods.typeAndSubmit(driver,"//*[contains(@id,'pickup-date-input')]",StartDate,"Start Date");
            //enter end date
            Reusable_Methods.click(driver,"//*[contains(@id,'dropoff-date-input')]","End Date");
            Reusable_Methods.click(driver,"//*[contains(@id,'dropoff-date-input')]",EndDate,"End Date");
            Reusable_Methods.click(driver,"//*[@class='title dark']","Dark Title");
            Thread.sleep(1000);
            //enter start time
            Reusable_Methods.mouseClick(driver,"//*[contains(@id,'start-time-select-option')]","Start Time");
            Thread.sleep(2000);
            Reusable_Methods.click(driver,"//*[contains(@id,'start-time-select-option') and @data-title='"+StartTime+"']","Start Time");
            //enter end time
            Reusable_Methods.mouseClick(driver,"//*[contains(@id,'end-time-select-option')]","End Time");
            Thread.sleep(2000);
            Reusable_Methods.click(driver,"//*[contains(@id,'dateRangeInput-end-time-select-option') and @data-title='"+EndTime+"')]","End Time");
            //clicking on title
            Reusable_Methods.click(driver,"//*[@class='title dark']","Dark Title");
            //Thread.sleep(4000);
            //click on search
            Reusable_Methods.click(driver,"//*[contains(@id,'submit')]","Search");
            Thread.sleep(3000);
            //select small
            //Reusable_Methods.click(driver,"//*[contains(@class,'closeIcon')]","Close Icon");

            Reusable_Methods.click(driver,"//*[@contains(text(),'Small')]",VehicleSize,"Car Size");
            Thread.sleep(2000);
            //Reusable_Methods.click(driver,"//*[contains(@class,'closeIcon')]","Close Icon");
            //click on view deal
            //Reusable_Methods.mouseClick(driver,"//*[@class='_iae _imQ _ix6 _ia1 _h-Y _mov _iFS _ii0 _iai']","Deal");
            Reusable_Methods.clickByIndex(driver,"//*[contains(text(),'View Deal')]",2,"View Deal");
            //go to opened tab
            ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window((String)tabs.get(1));

            //Total due
            String TotalDue = Reusable_Methods.captureText(driver,"//*[contains(text(),'$')]","Total Due");

            ArrayList<String> tabs2 = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window((String)tabs2.get(1));

            //store and send it to the empty column in excel writable file
            Label label = new Label(6, i, TotalDue);
            writableSheet.addCell(label);
            //adding this label to the writable sheet



        }//end of for loop
    }//end of test

    @AfterSuite
    public void closingInfo() throws IOException, WriteException, InterruptedException {
        writableFile.write();
        writableFile.close();
        Thread.sleep(2000);
        //driver.quit();
    }//end of after suite

}//end of java class
