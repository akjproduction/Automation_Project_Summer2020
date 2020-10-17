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
import java.sql.Driver;

public class Assignment_6 {
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
        readableFile = Workbook.getWorkbook(new File("src/main/resources/ActionItem_Hulu.xls"));
        //locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/ActionItem_Hulu_Results.xls"), readableFile);
        //define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();
    }//end of before suite

    @Test
    public void getTotalPrice() throws InterruptedException, WriteException {
        //all the test steps have to go inside for loop
        for (int i = 1; i < rowCount; i++) {
            //get the content of the cell
            //column is hard coded and row is dynamic(i)
            String Email = writableSheet.getCell(0, i).getContents();
            String Password = writableSheet.getCell(1, i).getContents();
            String Name = writableSheet.getCell(2, i).getContents();
            String birthMonth = writableSheet.getCell(3, i).getContents();
            String birthDay = writableSheet.getCell(4, i).getContents();
            String birthYear = writableSheet.getCell(5, i).getContents();
            String zipCode = writableSheet.getCell(6,i).getContents();
            String Gender = writableSheet.getCell(7, i).getContents();
            String cardNumber = writableSheet.getCell(8, i).getContents();


            //navigate to Hulu.com
            driver.navigate().to("https://www.hulu.com");
            Thread.sleep(2000);
            //Capture title
            String actualTitle = driver.getTitle();
            if (actualTitle == "Stream TV and Movies") {
                System.out.println("Matched expected title");
            } else {
                System.out.println("Expected title did not match. Detected Title is " + actualTitle);
            }
            //click on start your free trial
            Reusable_Methods.click(driver, "//*[@class='button--cta button--white Masthead__input-cta']", "Start Your Free Trial");
            //click on select under most popular
            Reusable_Methods.click(driver, "//*[@aria-label='Select Hulu for $5.99/month']", "Select - Hulu");
            //Enter email
            Reusable_Methods.sendKeys(driver, "//*[@id='email']", Email, "Email");
            //Enter password
            Reusable_Methods.sendKeys(driver, "//*[@id='password']", Password, "Password");
            //Enter name
            Reusable_Methods.sendKeys(driver, "//*[@id='firstName']", Name, "Name");
            //Select birth Month
            Reusable_Methods.click(driver, "//*[@class='field field__month']", "Month");
            Reusable_Methods.click(driver, "//*[@id='birthdayMonth-menu']", birthMonth, "Months");

            //Select birth Day
            Reusable_Methods.click(driver, "//*[@class='field field__day']", "Day");
            Reusable_Methods.click(driver, "//*[@id='birthdayDay-menu']", birthDay, "Days");
            //Select birth Year
            Reusable_Methods.click(driver, "//*[@class='field field__year']", "Year");
            Reusable_Methods.click(driver, "//*[@id='birthdayYear-menu']", birthYear, "Year");

            //Entering Zipcode
            Reusable_Methods.sendKeys(driver,"//*[@id='legalZip']",zipCode,"ZipCode");

            //Select Gender
            Reusable_Methods.click(driver, "//*[@class='field gender']", "Gender");
            Reusable_Methods.click(driver, "//*[@id='gender-menu']", Gender, "Gender");
            //Click on continue
            Reusable_Methods.click(driver, "//*[@class='button button--continue ']", "Continue");
            //card error message
            String err1 = Reusable_Methods.captureText(driver, "//*[@class='modal-body']", "Error Message");
            System.out.println("Error Message " + err1);
            //capture payment
            String result = Reusable_Methods.captureText(driver, "//*[@class='panel large']", "Payment");
            System.out.println("Payment " + result);
            //enter credit card number
            Reusable_Methods.sendKeys(driver, "//*[@id='creditCard']", cardNumber, "Card Number");
            //card error message
            String err = Reusable_Methods.captureText(driver, "//*[@class='errors']", "Error Message");
            System.out.println("Error Message " + err);

            //store and send it to the empty column in excel writable file
            Label label = new Label(9, i, result);
            Label label1 = new Label(10, i, err);
            writableSheet.addCell(label);
            writableSheet.addCell(label1);
            //adding this label to the writable sheet


        }//end of for loop

    }//end of test

    @AfterSuite
    public void closingInfo() throws IOException, WriteException, InterruptedException {
        writableFile.write();
        writableFile.close();
        Thread.sleep(2000);
        driver.quit();
    }//end of after suite
}//end of java class
