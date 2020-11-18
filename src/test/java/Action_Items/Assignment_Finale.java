package Action_Items;

import Page_Object_Framework.Google_POM.Base_Class;
import Reusable_Library.Abstract_Class_BOA;
import org.testng.annotations.Test;

public class Assignment_Finale extends Abstract_Class_BOA {

    @Test
    public void GoogleSearhResult()  throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Base_Class.google_home().searchField("Bank of America");
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
}
