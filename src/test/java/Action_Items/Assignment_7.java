package Action_Items;
//MohammedForkan_ActionItem7_Express
import Reusable_Library.Abstract_Class_AI;
import Reusable_Library.Reusable_Methods;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.write.Label;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class Assignment_7 extends Abstract_Class_AI {


    @Test
    public void Express() throws InterruptedException, WriteException, IOException {
        driver.manage().deleteAllCookies();// delete all cookies before navigating
        logger.log(LogStatus.INFO, "Navigating to Express");
        driver.navigate().to("https://www.express.com");//navigating to express.com
        Thread.sleep(2000);
        Reusable_Methods_Loggers.checkTitle(driver, "https://www.express.com", "Men's and Women's Clothing");//checking title
        Reusable_Methods_Loggers.mouseHover(driver, "//*[@href='/mens-clothing']", logger, "Men");//hovering over men tab
        Thread.sleep(1000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[contains(text(),'Shirts') and @href='/mens-clothing/shirts/cat410008']", logger, "Shirts");//clicking shirts
        Thread.sleep(5000);
        //scroll using Java Script Exec
        JavascriptExecutor Jse = (JavascriptExecutor) driver;
        Jse.executeScript("scroll(0,450)");// scrolling 450px down
        Thread.sleep(1000);
        Reusable_Methods_Loggers.clickByIndex(driver, "//*[@class='_1ddDj _136PD']", 2, logger, "3rd Shirt"); //selecting third item
        Thread.sleep(2500);
        Reusable_Methods_Loggers.click(driver, "//*[@class='close-text drawer-close']", logger, "close popup");//closing unexpected popup

        //all the test steps have to go inside for loop
        for (int i = 1; i < rowCount; i++) {
            //get the content of the cell
            //column is hard coded and row is dynamic(i)
            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String address = writableSheet.getCell(6, i).getContents();
            String zipCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String cardNumber = writableSheet.getCell(10, i).getContents();
            String ExpMonth = writableSheet.getCell(11, i).getContents();
            String ExpYear = writableSheet.getCell(12, i).getContents();
            String cvvCode = writableSheet.getCell(13, i).getContents();

            Reusable_Methods_Loggers.click(driver, "//*[@value='" + size + "']", logger, "Size");
            Thread.sleep(1000);
            Reusable_Methods_Loggers.click(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']", logger, "Add to Bag");
            Thread.sleep(1000);
            //click on view bag
            Reusable_Methods_Loggers.mouseClick(driver, "//*[@aria-label='view bag']", logger, "view bag");
            Thread.sleep(3000);
            //select quantity
            Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@id='qdd-0-quantity']", quantity, logger, "Quantity");
            Thread.sleep(2000);
            //checkout
            Reusable_Methods_Loggers.click(driver, "//*[@id='continue-to-checkout']", logger, "Checkout");
            Thread.sleep(2000);
            //checkout as guest
            Reusable_Methods_Loggers.click(driver, "//*[@class='_1UFak _2YpK4 _1f9t- _2yrqS']", logger, "Checkout as Guest");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@data-granify-event='click_close']", logger, "close checkout popup");
            //first name
            Reusable_Methods_Loggers.click(driver, "//*[@name='firstname']", logger, "First Name");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='firstname']", firstName, logger, "First Name");
            //last name
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='lastname']", logger, "Last Name");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='lastname']", lastName, logger, "Last Name");//entering last name
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='email']", logger, "Email");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='email']", email, logger, "Email");//entering email
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='confirmEmail']", logger, "Confirm Email");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='confirmEmail']", email, logger, "Confirm Email");//entering confirmation email
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='phone']", logger, "Phone");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='phone']", phoneNumber, logger, "Phone");//entering phone
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@type='submit']", logger, "Continue");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='shipping.line1']", logger, "Address");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='shipping.line1']", address, logger, "Address");//entering address
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='shipping.postalCode']", logger, "ZipCode");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='shipping.postalCode']", zipCode, logger, "ZipCode");//entering zipcode
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='shipping.city']", logger, "City");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='shipping.city']", city, logger, "City");//entering city
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='shipping.state']", logger, "State");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@name='shipping.state']", state, logger, "State");//selecting state
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']", logger, "Continue");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.click(driver, "//*[@type='submit']", logger, "Continue");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='creditCardNumber']", logger, "Credit Card Number");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='creditCardNumber']", cardNumber, logger, "Credit Card Number");//entering credit card number
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='expMonth']", logger, "Exp Month");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@name='expMonth']", ExpMonth, logger, "Exp Month");//exp month
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='expYear']", logger, "Exp Year");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@name='expYear']", ExpYear, logger, "Exp Year");//exp year
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@name='cvv']", logger, "CVV");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='cvv']", cvvCode, logger, "CVV");//entering cvv
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver, "//*[@type='submit']", logger, "Place Order");//placing order
            Thread.sleep(2000);
            Reusable_Methods_Loggers.captureResult(driver, "//*[@role='dialog']", logger, "Error Msg");//error msg

            String errorMessage = writableSheet.getCell(14, i).getContents();
            //store and send it to the empty column in excel writable file
            Label label = new Label(14, i, errorMessage);
            writableSheet.addCell(label);
            //adding this label to the writable sheet
        }//end of for loop
        writableFile.write();
        writableFile.close();
    }//end of test

}//end of java class
