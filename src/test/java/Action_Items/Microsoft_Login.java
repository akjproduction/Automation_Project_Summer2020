package Action_Items;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class Microsoft_Login  {
    //declare all the global variables outside
    WebDriver driver = null;
    @BeforeSuite
    public void setDriver() throws InterruptedException {
        //setting the chrome driver
        driver = Reusable_Methods.getDriver();
        //locate the readable excel workbook
        driver.manage().deleteAllCookies();// delete all cookies before navigating
        //navigate to microsoft.com
        driver.navigate().to("https://www.microsoft.com");
        Thread.sleep(2000);
        Reusable_Methods.mouseClick(driver,"//*[@id='mectrl_main_trigger']","login");
        Thread.sleep(1000);
        Reusable_Methods.typeAndSubmit(driver,"//*[@type='email']","sharuk.k@gmail.com","type email");
        Thread.sleep(2000);
        Reusable_Methods.typeAndSubmit(driver,"//*[@name='passwd']","tomamir823","enter pass");
        Thread.sleep(2000);
        Reusable_Methods.mouseClick(driver,"//*[@type='button']","no");
        Thread.sleep(5000);
        Reusable_Methods.mouseClick(driver,"//*[@id='mectrl_headerPicture']","account");
        Thread.sleep(2000);
        Reusable_Methods.mouseClick(driver,"//*[@id='mectrl_body_signOut']","signout");
        Thread.sleep(5000);
        driver.quit();
    }
}
