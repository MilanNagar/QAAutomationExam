package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MakeAppointmentPage  {

    private WebDriver driver;

    //All the elements  used in the Make AppointmentPage

    private By makeAppointmentMessage=By.linkText("Make Appointment");
    private By selectFacilityOption = By.name("facility");
    private By clickHospitalReadmissionBtn=By.name("hospital_readmission");
    private By clickHealthProgramBtn=By.xpath("//*[@name=\"programs\"]");
    private By selectVisitDate=By.xpath("//*[@id=\"txt_visit_date\"]");
    private By enterComments=By.id("txt_comment");
    private By clickBookAppointmentButton =By.id("btn-book-appointment");






    //My constructor I created
    public MakeAppointmentPage(WebDriver driver){
        this.driver=driver;
    }

    //Confirming I am on the make appointment page
    public String getMakeAppointmentMessage(){
        return driver.findElement(makeAppointmentMessage).getText();
    }



    // Used to select the user facility option
    public void selectFacility(String Facility){
        Select rollDropdown = new Select(driver.findElement(selectFacilityOption));
        rollDropdown.selectByVisibleText(Facility);


    }
    //Used to click the (Apply for hospital readmission button)
    public void clickReadmissionBtn (){
        driver.findElement(clickHospitalReadmissionBtn).click();
    }

    //Used to select different Healthcare program
    public void clickHealthProgramme  (Integer ValueOfRadioButton){
        driver.findElements(clickHealthProgramBtn).get(ValueOfRadioButton.intValue()).click();

    }

    //Used to set the date
    public void setVisitDate(String date){
        driver.findElement(selectVisitDate).sendKeys(date);
    }

    //Used to add a comment
    public void setComment(String comment){
        driver.findElement(enterComments).sendKeys(comment);
    }

    //Used to click book appointment button
    public void bookAppointmentButtonClicked( ){
        driver.findElement(clickBookAppointmentButton).click();

    }



}
