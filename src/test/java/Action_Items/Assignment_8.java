package Action_Items;

import Reusable_Library.Abstract_Class_Cross_Browser_AI;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Assignment_8 extends Abstract_Class_Cross_Browser_AI {

    @Test
    public void FedEx() throws InterruptedException {
        //Navigating to FedEx
        logger.log(LogStatus.INFO,"Navigating to FedEx.com");
        driver.navigate().to("https://www.fedex.com/en-us/home.html");
        Thread.sleep(2000);
        //Clicking on Design & Print
        Reusable_Methods_Loggers.click(driver,"//*[@aria-label='Open Design & Print menu']",logger,"Design & Print");
        Thread.sleep(3000);
        //Clicking on upload file
        Reusable_Methods_Loggers.click(driver,"//*[@alt='Upload a Print-Ready File']",logger,"Upload File");
        Thread.sleep(3000);
        //Uploading file with robot method
        Reusable_Methods_Loggers.checkTitle(driver, "https://www.fedex.com/apps/printonline/#!", "FedEx Office Print");//checking title
        Thread.sleep(3000);
        //Clicking on Document Printing
        Reusable_Methods_Loggers.click(driver,"//*[@alt='Document Printing']",logger,"Document Printing");
        Thread.sleep(3000);
        //Clicking on Custom Projects
        Reusable_Methods_Loggers.click(driver,"//*[@alt='Copies & Custom Projects']",logger,"Copies & Custom Projects");
        Thread.sleep(3000);
        //Reusable_Methods_Loggers.clickPopup(driver,"//*[@alt='close']",logger,"Close Popup");
        //Thread.sleep(3000);
        Reusable_Methods_Loggers.click(driver,"//*[@name='upload-files-button']",logger,"Upload");
        Thread.sleep(3500);
        //Locating file by absolute path
        Reusable_Methods_Loggers.uploadFile("D:\\Dropbox\\QA Class\\Automation_Project_Summer2020\\src\\main\\resources\\Fedex.jpg");
        Thread.sleep(10000);
        //Clicking on Continue with Existing Resolution
        Reusable_Methods_Loggers.click(driver,"//*[@class='button__ok']",logger,"Continue with Existing");
        Thread.sleep(10000);
        //Clicking on Quantity
        Reusable_Methods_Loggers.click(driver,"//*[@class='quantity-field']",logger,"Quantity");
        Thread.sleep(1000);
        //Entering 5 on quantity
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@class='quantity-field']","5",logger,"Quantity");
        Thread.sleep(1000);
        //Clicking on outside of Quantity to update #5 in quantity
        Reusable_Methods_Loggers.click(driver,"//*[@class='text-align-right']",logger,"Outside Quantity Box");
        //Clicking on add to cart
        Reusable_Methods_Loggers.click(driver,"//*[@name='update_quanity-addToCart-lbl']",logger,"Add to Cart");
        Thread.sleep(3000);
        //Clicking on Checkout
        Reusable_Methods_Loggers.click(driver,"//*[@name='cart_page-chkOut-lbl']",logger,"Checkout");
        Thread.sleep(3000);
        //Clicking on Proceed as guest
        Reusable_Methods_Loggers.click(driver,"//*[@id='continueAsGuest']",logger,"Proceed as Guest");
        Thread.sleep(3000);
        //Clicking on Miles Radius
        Reusable_Methods_Loggers.click(driver,"//*[@id='radiusSelect']",logger,"Radius");
        Thread.sleep(3000);
        //Clicking on 5 miles
        Reusable_Methods_Loggers.click(driver,"//*[@value='5']",logger,"5 Miles");
        Thread.sleep(3000);
        //Entering zipcode 11218
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@placeholder='Enter zip code or city and state']","11218",logger,"ZipCode");
        Thread.sleep(5000);
        //Capturing Location Info
        Reusable_Methods_Loggers.captureResult(driver,"//*[@id='5732']",logger,"Location, Name & Distance");
        Reusable_Methods_Loggers.captureResult(driver,"//*[@class='details']",logger,"Address, Phone Number & Hours");
        Thread.sleep(10000);

        System.out.println("The Test is now Completed");
    }// End of test

}//end of java class
