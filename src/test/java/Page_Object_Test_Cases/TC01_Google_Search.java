package Page_Object_Test_Cases;

import Page_Object_Framework.Google_POM.Base_Class;
import Reusable_Library.Abstract_Class;
import org.testng.annotations.Test;

public class TC01_Google_Search extends Abstract_Class {

    @Test
    public void GoogleSearhResult() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Base_Class.google_home().searchField("Cars");
        Base_Class.google_home().submitButton();
        Thread.sleep(2400);
        Base_Class.google_search_result().getSearchNumber();
    }//end of test

    public static void compareTitle(String expected){
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expected)){
            // print and log pass
        } else {
            // print and log fail
        }
    }

}//end of test
