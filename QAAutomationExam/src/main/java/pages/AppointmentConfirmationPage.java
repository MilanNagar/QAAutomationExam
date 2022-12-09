package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentConfirmationPage {

    private WebDriver driver;

    private By appointmentConfirmationPage = By.tagName("h2");
    private By appointmentConfirmationMessage=By.xpath("//*[@id=\"summary\"]/div/div/div[1]/p");
    private By goToHomepage=By.linkText("Go to Homepage");

    //My constructor (AppointmentConfirmationPage) created
    public AppointmentConfirmationPage(WebDriver driver){
        this.driver=driver;
    }

    //Confirming the Appointment Confirmation Message
    public String getAppointmentConfirmationMessage(){
       return driver.findElement(appointmentConfirmationMessage).getText();
    }

    //Confirming the Appointment Confirmation Page
    public String getAppointmentConfirmationPage(){
        return driver.findElement(appointmentConfirmationPage).getText();
    }


    //After clicking the go to home page button user will be taken to make appointment screen(Home page)
    public HomePage clickGoToHomePageBtn(){
        driver.findElement(goToHomepage).click();
        return new HomePage(driver);
    }
}



