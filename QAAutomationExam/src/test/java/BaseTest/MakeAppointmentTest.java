package BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AppointmentConfirmationPage;
import pages.HomePage;
import pages.MakeAppointmentPage;


public class MakeAppointmentTest  extends BaseTests{



    @Test(priority = 2,dataProvider = "MakeAppointmentData")
    public void makeAppointmentTest(String Facility,Integer ValueOfRadioButton,String date,String comment){


        MakeAppointmentPage makeAppointmentTest = new MakeAppointmentPage(driver);
        makeAppointmentTest.selectFacility(Facility);
        makeAppointmentTest.clickReadmissionBtn();
        makeAppointmentTest.clickHealthProgramme(ValueOfRadioButton);
        makeAppointmentTest.setVisitDate(date);
        makeAppointmentTest.setComment(comment);
        makeAppointmentTest.bookAppointmentButtonClicked();



        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        Assert.assertTrue(true,appointmentConfirmationPage.getAppointmentConfirmationPage());
        Assert.assertTrue(true,appointmentConfirmationPage.getAppointmentConfirmationMessage());
        appointmentConfirmationPage.clickGoToHomePageBtn();






    }

    @DataProvider()
    public Object[][]MakeAppointmentData(){
        Object[][] data = new Object[3][4];
        data[0][0]="Tokyo CURA Healthcare Center";data[0][1] =0 ; data[0][2]="22/12/2022";data[0][3] ="Checked In";
        data[1][0]="Hongkong CURA Healthcare Center";data[1][1] =1 ; data[1][2]="23/02/2022";data[1][3] ="Admission";
        data[2][0]="Seoul CURA Healthcare Center";data[2][1] =2 ; data[2][2]="22/07/2022";data[2][3] ="Checked Out";
        return data;
    }



}
