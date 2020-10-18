package Action_Items;

import Reusable_Library.Abstract_Class_AI;
import Reusable_Library.Abstract_Class_ICAI;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static jxl.biff.FormatRecord.logger;

public class In_Class_Assignment_2 extends Abstract_Class_ICAI {
@Test
        public void Yahoo() throws InterruptedException, WriteException, IOException {
    WebDriver driver = Reusable_Methods_Loggers.getDriver();

    //navigate to yahoo page
    driver.manage().deleteAllCookies();// delete all cookies before navigating
        logger.log(LogStatus.INFO, "Navigating to Yahoo");
        driver.navigate().to("https://www.yahoo.com"); //navigating to Yahoo.com
        Thread.sleep(2000);
    //get the count of all links in  yahoo home page
    List<WebElement> linkCount = driver.findElements(By.xpath("//*[@class='_yb_e0gik']"));
    //print out the link count
    System.out.println("Link count is " + linkCount.size());
    Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='ybar-sbq']","Nutrition",logger,"Search Bar");
    Thread.sleep(1000);
    Reusable_Methods_Loggers.click(driver,"//*[@value='Search']",logger,"Search button");
    Thread.sleep(2000);
    //scroll top the bottom
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("scroll(0,4000)");
    Thread.sleep(2000);
    //capture the yahoo search result
    String capture = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='compPagination']",logger,"Search Result");
    String[]  result = capture.split("Next");
    System.out.println("my Search result is " +result);
    jse.executeScript("scroll(0,-4000)");
    Thread.sleep(2000);
    Reusable_Methods_Loggers.click(driver,"//*[text()='Images']",logger,"Images");
    Thread.sleep(3000);
    List<WebElement> imageCount = driver.findElements(By.xpath("//*[@class='_yb_e0gik']"));
    System.out.println("Link count is " + imageCount.size());
    Thread.sleep(2000);
    Reusable_Methods_Loggers.click(driver,"//*[text()='Sign In']",logger,"Sign In");
    Thread.sleep(2000);
    boolean checkboxState = driver.findElement(By.xpath("//*[@for='persistent']")).isSelected();
    //expecting the checkbox to be selected
    if (checkboxState == true){
        System.out.println("Checkbox is selected as expected");
    }else {
        System.out.println("Checkbox is not selected by default");
    }//end of if else
    Thread.sleep(2000);
    Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='username']","testuserid",logger,"username");
    Thread.sleep(500);
    Reusable_Methods_Loggers.click(driver,"//*[@name='signin']",logger,"Next ");
    Thread.sleep(2000);
    String msg = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='error-msg']",logger,"error msg");
    if (msg.equalsIgnoreCase("Sorry, we don't recognize this email")){
        System.out.println("error msg match as expected");
    }else{
        System.out.println("error msg didn't match as expected");
    }//end of if else

    }
}//end of java class
