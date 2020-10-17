package Action_Items;

import Reusable_Library.Abstract_Class_AI;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.write.Label;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Blank_Test {
    /*
    //Test

    package Action_Items;

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

    public class Assignment_7 extends Abstract_Class_AI {


        @Test
        public void Express() throws InterruptedException {
            driver.manage().deleteAllCookies();// delete all cookies before navigating
            logger.log(LogStatus.INFO, "Navigating to Express");
            driver.navigate().to("https://www.express.com");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.checkTitle(driver, "https://www.express.com", "Men's and Women's Clothing");
            Reusable_Methods_Loggers.mouseHover(driver, "//*[@href='/mens-clothing']", logger, "Men");
            Thread.sleep(1000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[contains(text(),'Shirts') and @href='/mens-clothing/shirts/cat410008']", logger, "Shirts");
            Thread.sleep(5000);
            //scroll using Java Script Exec
            JavascriptExecutor Jse = (JavascriptExecutor) driver;
            Jse.executeScript("scroll(0,450)");// scrolling 450px down
            Thread.sleep(1000);
            Reusable_Methods_Loggers.clickByIndex(driver, "//*[@class='_1ddDj _136PD']", 2, logger, "3rd Shirt");
            Thread.sleep(2500);
            Reusable_Methods_Loggers.click(driver,"//*[@class='close-text drawer-close']",logger,"close popup");

            //all the test steps have to go inside for loop
            for (int i = 1; i < rowCount; i++) {
                //get the content of the cell
                //column is hard coded and row is dynamic(i)
                String size = writableSheet.getCell(0, i).getContents();
                // String quantity = writableSheet.getCell(1, i).getContents();
                //String firstName = writableSheet.getCell(2, i).getContents();
                //String lastName = writableSheet.getCell(3, i).getContents();
                // String email = writableSheet.getCell(4, i).getContents();
                // String phoneNumber = writableSheet.getCell(5, i).getContents();
                // String address = writableSheet.getCell(6, i).getContents();
                // String zipCode = writableSheet.getCell(7, i).getContents();
                // String city = writableSheet.getCell(8, i).getContents();
                //  String state = writableSheet.getCell(9, i).getContents();
                // String cardNumber = writableSheet.getCell(10, i).getContents();

                Reusable_Methods_Loggers.click(driver, "//*[@value='" + size + "']", logger, "Size");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']", logger, "Add to Bag");
                Thread.sleep(1000);
                //click on view bag
                Reusable_Methods_Loggers.mouseClick(driver, "//*[@aria-label='view bag']", logger, "view bag");
                Thread.sleep(3000);

            }//end of for loop
        }//end of test 1

        @Test(dependsOnMethods = "Express")
        public void ExpressCheckout() throws InterruptedException {
            //all the test steps have to go inside for loop
            for (int i = 1; i < rowCount; i++) {
                //get the content of the cell
                //column is hard coded and row is dynamic(i)
                //  String size = writableSheet.getCell(0, i).getContents();
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


                //select quantity
                Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@id='qdd-0-quantity']", quantity, logger, "Quantity");
                Thread.sleep(2000);
                //checkout
                Reusable_Methods_Loggers.click(driver, "//*[@id='continue-to-checkout']", logger, "Checkout");
                Thread.sleep(2000);
                //checkout as guest
                Reusable_Methods_Loggers.click(driver, "//*[@class='_1UFak _2YpK4 _1f9t- _2yrqS']", logger, "Checkout as Guest");
                Thread.sleep(2000);
                Reusable_Methods_Loggers.click(driver,"//*[@data-granify-event='click_close']",logger,"close checkout popup");
                //first name
                Reusable_Methods_Loggers.click(driver, "//*[@name='firstname']", logger, "First Name");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='firstname']", firstName, logger, "First Name");
                //last name
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='lastname']", logger, "Last Name");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='lastname']", lastName, logger, "Last Name");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='email']", logger, "Email");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='email']", email, logger, "Email");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='confirmEmail']", logger, "Confirm Email");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='confirmEmail']", email, logger, "Confirm Email");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='phone']", logger, "Phone");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='phone']", phoneNumber, logger, "Phone");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@type='submit']", logger, "Continue");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='shipping.line1']", logger, "Address");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='shipping.line1']", address, logger, "Address");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='shipping.postalCode']", logger, "ZipCode");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='shipping.postalCode']", zipCode, logger, "ZipCode");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='shipping.city']", logger, "City");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='shipping.city']", city, logger, "City");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='shipping.state']", logger, "State");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@name='shipping.state']", state, logger, "State");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']", logger, "Continue");
                Thread.sleep(3000);
                Reusable_Methods_Loggers.click(driver, "//*[@type='submit']", logger, "Continue");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='creditCardNumber']", logger, "Credit Card Number");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='creditCardNumber']", cardNumber, logger, "Credit Card Number");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='expMonth']", logger, "Exp Month");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@name='expMonth']", ExpMonth, logger, "Exp Month");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='expYear']", logger, "Exp Year");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@name='expYear']", ExpYear, logger, "Exp Year");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver, "//*[@name='cvv']", logger, "CVV");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='cvv']", cvvCode, logger, "CVV");
                Thread.sleep(1000);
                Reusable_Methods_Loggers.click(driver,"//*[@type='submit']",logger,"Place Order");
                Thread.sleep(2000);
                Reusable_Methods_Loggers.captureResult(driver, "//*[@id='rvn-note-NaN']", logger, "Error Msg");


            }//end of for loop
        }//end of test 2

        @Test (dependsOnMethods = "ExpressCheckout")
        public void excelEntry() throws WriteException {
            int i = 0;
            String errorMessage = writableSheet.getCell(14, i).getContents();
            //store and send it to the empty column in excel writable file
            Label label = new Label(14, i, errorMessage);
            writableSheet.addCell(label);
            //adding this label to the writable sheet
        }//end of test 3

        */
    }//end of java class



    //Test



