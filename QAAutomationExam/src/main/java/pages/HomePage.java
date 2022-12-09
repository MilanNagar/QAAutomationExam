package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    public WebDriver driver;

    //All the elements  used in the Make HomePage
    private By homePageText = By.tagName("h3");
    private By clickMyAppointmentButton = By.cssSelector("#btn-make-appointment");


    //My constructor I created
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //Used to confirm we are on the homepage
    public String getHomePageText(){
        return  driver.findElement(homePageText).getText();
    }

    //Used to click on the make appointment button and traverse to the login page
    public LoginPage makeAppointment(){
        driver.findElement(clickMyAppointmentButton).click();
        return new LoginPage(driver);

    }


}
