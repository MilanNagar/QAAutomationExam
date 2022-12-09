package BaseTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.HomePage;
import pages.LoginPage;
import pages.MakeAppointmentPage;

public class LoginTest extends BaseTests {



    @Test(priority = 1,dataProvider = "LoginData")
    public void loginSuccessfulTest( String Username,String Password, boolean Success){

        String getHomePageText = homePage.getHomePageText();
        Assert.assertEquals(getHomePageText,"We Care About Your Health");
        LoginPage loginSuccessfulTest =homePage.makeAppointment();
        Assert.assertTrue(true,loginSuccessfulTest.getLoginPageMessage());
        loginSuccessfulTest.setUsername(Username);
        loginSuccessfulTest.setPassword(Password);
        Assert.assertTrue(Success,loginSuccessfulTest.userName());
        Assert.assertTrue(true,loginSuccessfulTest.password1());
        MakeAppointmentPage makeAppointmentMessage=loginSuccessfulTest.clickLoginButton();
        Assert.assertTrue(true,makeAppointmentMessage.getMakeAppointmentMessage());



    }

    @DataProvider()
    public Object[][]LoginData(){
        Object[][] data = new Object[1][3];
        data[0][0]="John Doe";data[0][1] = "ThisIsNotAPassword"; ;data[0][2]=true;
        return data;
    }
}
