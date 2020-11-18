package Action_Items;

import Reusable_Library.Abstract_Class_BOA;
import Reusable_Library.Reusable_Methods;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import gherkin.lexer.Th;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BoA_Assignment extends Abstract_Class_BOA {


    @Test
    public void BoA_Test_Case1() throws InterruptedException {
        driver.manage().deleteAllCookies(); //deleting all cookies
        logger.log(LogStatus.INFO, "Navigating to Bank of America");
        driver.navigate().to("https://www.bankofamerica.com/"); //navigating to BoA
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.checkTitle(driver, "https://www.bankofamerica.com/", "Bank of America - Banking, Credit Cards"); //checking title
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.mouseClick(driver, "//*[@id='navChecking']", logger, "Checking"); //clicking on checking tab
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@id='DCTAL13O']", logger,"Open a Checking Account"); // opening
        Thread.sleep(2000); //delay
        //scroll using Java Script Exec
        JavascriptExecutor Jse = (JavascriptExecutor) driver;
        Jse.executeScript("scroll(0,200)");// scrolling 450px down
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@aria-label='Bank of America Advantage SafeBalance Banking register sign Open now']",logger,"SafeBalance Banking");
        Thread.sleep(2000); //delay
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String)tabs.get(1));
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@id='zipCodeModalInputField']","11218",logger,"ZipCOde");//entering zipcode
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@id='rb-savings-account-none']",logger,"Only SafeBalance Account");//clicking on 2nd option
        Jse.executeScript("scroll(0,200)");// scrolling 450px down
        Reusable_Methods_Loggers.click(driver,"//*[@id='go-to-application-mediumup']",logger,"Go to Application");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_name_tb_fnm']","Mohammed",logger,"First Name");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_name_tb_lnm']","Amir",logger,"Last Name");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_addr_tb_line1']","123 Home Street",logger,"Address");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_addr_tb_city']","Brooklyn",logger,"City");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='zz_addr_lb_state']","New York",logger,"State");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_addr_tb_zip']","11218",logger,"ZipCode");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_phn_tb_ppno']","9172009247",logger,"Phone");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_email_tb_addr']","xyz@zmail.com",logger,"Email");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_email_tb_readdr']","xyz@zmail.com",logger,"Re-Email");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@name='zz_citz_lb_uscit']",logger,"Yes");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_citz_tb_ssn']","054891614",logger,"SSN");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_citz_tb_ssn_2']","054891614",logger,"SSN_Verify");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@for='zz_citz_lb_dualcit_no_v_1-real']",logger,"No");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='zz_addr_lb_rescty']","United States",logger,"Residence");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='zz_citz_tb_dob']","01311990",logger,"D0B");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='zz_emp_lb_srcinc']","Social Security",logger,"Source of Income");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='zz_emp_lb_ssnocc']","Unemployed",logger,"Source of Income");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@name='btn_continue']",logger,"Continue");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@id='zz_depfund_ra_zero_v_1-real']",logger,"Deposit Later");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@value='noDebitCardWanted']",logger,"Debit Card");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@name='btn_continue']",logger,"Continue");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@name='zz_ecd_primAppConsent']",logger,"Terms 1");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@name='btn_continue']",logger,"Continue");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@name='zz_ecd_primAppConsent']",logger,"Terms 2");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@name='btn_continue']",logger,"Continue");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@name='zz_ecd_primAppConsent']",logger,"Terms 3");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@name='btn_continue']",logger,"Continue");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.ScreenShot(driver,logger,"Application Information Review");//Info Preview Screetshot
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@name='btn_submit']",logger,"Submit");//submit
        Thread.sleep(55000); //delay
        String result = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='row text-center']",logger,"Msg");//capturing error msg
        logger.log(LogStatus.PASS, "Error Message is: \n" + "\n" + result);
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.ScreenShot(driver,logger,"Application");//screen shot
        Thread.sleep(10000);
    }//End of test case 1

    @Test (dependsOnMethods = "BoA_Test_Case1")
    public void BoA_Test_Case2() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"start-maximized"});
        options.addArguments(new String[]{"incognito"});
        WebDriver driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies(); //deleting all cookies
        logger.log(LogStatus.INFO, "Navigating to Bank of America");
        driver.navigate().to("https://www.bankofamerica.com/"); //navigating to BoA
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.checkTitle(driver, "https://www.bankofamerica.com/", "Bank of America - Banking, Credit Cards"); //checking title
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='onlineId1']","userId",logger,"User Id");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='passcode1']","UserPassword123",logger,"Password");
        Thread.sleep(2000); //delay
        Reusable_Methods_Loggers.click(driver,"//*[@id='signIn']",logger,"Sign In");
        Thread.sleep(2000); //delay
        String result = Reusable_Methods_Loggers.captureResult(driver,"//*[@id='privacyText']",logger,"Privacy Msg");
        logger.log(LogStatus.PASS, "Privacy Message: \n" + result);
        Reusable_Methods_Loggers.ScreenShot(driver,logger,"Privacy Msg");//screen shot
        Thread.sleep(10000);

    }//End of test case 2
}// end of java class
