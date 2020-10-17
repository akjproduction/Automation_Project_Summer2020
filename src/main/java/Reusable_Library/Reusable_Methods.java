package Reusable_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Methods {

    public static WebDriver getDriver() {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");
        //defining the web driver that you'll be using
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of web driver

    //reusable method to click on element on any websites
    public static void click(WebDriver driver, String locator, String elementName) {
        // define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Clicking on " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        } catch (Exception err) {
            System.out.println("Unable to click on element " + err);
        }//end of exception
    }//end of click method with excel
    //reusable method to click on element on any websites
    public static void click(WebDriver driver, String locator, String userValue, String elementName) {
        // define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Clicking on " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        } catch (Exception err) {
            System.out.println("Unable to click on element " + err);
        }//end of exception
    }//end of click method
    //reusable method to type on element on any websites
    public static void sendKeys(WebDriver driver, String locator, String userValue, String elementName) {
        // define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Typing " + userValue);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception err) {
            System.out.println("Unable to type " + err);
        }//end of exception
    }//end of sendkeys method

    //reusable method to submit on element on any websites
    public static void submit(WebDriver driver, String locator, String elementName) {
        // define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("submitting on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
        } catch (Exception err) {
            System.out.println("Unable to type on element " + err);
        }//end of exception
    }//end of submit method

    //reusable method to dropdown on element on any websites

    public static void dropDownMenu(WebDriver driver, String locator, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Selecting " + userInput);
            WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select selectDropDown = new Select(dropDown);
            selectDropDown.selectByVisibleText(userInput);
        } catch (Exception err) {
            System.out.println("Unable to select from drop down menu " + err);
        }//end of exception
    }//end of dropdown method

    //reusable method for capturing text
    public static String captureText(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String text = "";
        try {
            System.out.println("Capturing " + elementName);
            text = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
            System.out.println(text);
        } catch (Exception err) {
            System.out.println("Unable to capture " + elementName + err);
        }
        return text;
    }//end of capturing text

    //reusable method for checking title text
    public static void checkTitle(WebDriver driver, String webAddress, String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.navigate().to(webAddress);
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title Contains 'KAYAK'");
        }else {
            System.out.println("Page title doesn't contains ");
        }
    }//end of check title

    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,9);
        try{
            System.out.println("Clicking by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception err) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + err);
        }
    }//end of click by index method

    public static void typeAndSubmit(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            System.out.println("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        } catch (Exception err) {
            System.out.println("Unable to enter on element " + elementName + " " + err);
        }
    }//end of type and submit method
    //method to click on an element
    public static void mouseClick(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception err) {
            System.out.println("Unable to mouse click element " + elementName + " " + err);
        }
    }//end of click method

}//end of java class
