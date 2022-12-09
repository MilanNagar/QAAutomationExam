package BaseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {


    protected static WebDriver driver;
    protected  HomePage homePage;

    String BaseUrl = "https://katalon-demo-cura.herokuapp.com/";



    @BeforeSuite
    public void setup(){
        //setup chrome driver
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BaseUrl);}

        @BeforeClass
        public void setup2() {
        homePage = new HomePage(driver);

    }
    //taking screenshots
    @AfterMethod
    public void captureScreenShots (ITestResult testResult){

        if (ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source =screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +"/resources/screenshots/Failed/"+ testResult.getName()+ "_" + testResult.getStartMillis() +".png");

            try {
                FileHandler.copy(source,destination);
            } catch (IOException e){
                e.printStackTrace();
            }

        }
        else {
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source =screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +"/resources/screenshots/Passed/"+ testResult.getName()+ "_" + testResult.getStartMillis() +".png");

            try {
                FileHandler.copy(source,destination);
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }




    //closing the browser
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
