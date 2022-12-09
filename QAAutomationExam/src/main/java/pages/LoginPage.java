package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //All the elements  used in the Make LoginPage

    private By loginPageText= By.xpath("//*[@id=\"login\"]/div/div/div[1]/p");
    private By inputUsername = By.name("username");
    private By userNameText=By.id("txt-username");
    private By inputPassword = By.name("password");
    private By passwordText=By.id("txt-password");
    private By clickLoginButton =By.id("btn-login");
    // add assertion to confirm user on log in page

    //My constructor I created
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //Used to confirm I am on the Login Page
    public String getLoginPageMessage(){
       return driver.findElement(loginPageText).getText();
    }

    //Used to assert username
    public String userName(){
       return driver.findElement(userNameText).getText();
    }

    //Used to set the username
    public void setUsername (String username ){
        driver.findElement(inputUsername).clear();
        driver.findElement(inputUsername).sendKeys(username);
    }


    //Used to assert password
    public String password1(){
        return driver.findElement(passwordText).getText();
    }

    //Used to set user password
    public void setPassword(String password){
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys(password);
    }


    //Used to click on the login button and traverse to the make appointment page
    public MakeAppointmentPage clickLoginButton(){
        driver.findElement(clickLoginButton).click();
        return new MakeAppointmentPage(driver);
    }


}
