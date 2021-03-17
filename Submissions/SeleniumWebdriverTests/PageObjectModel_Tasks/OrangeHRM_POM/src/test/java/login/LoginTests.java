package login;

import PageObject.DashboardPage;
import org.testng.annotations.Test;
import setup.SetupTests;

public class LoginTests extends SetupTests {
//TestNG annotation
@Test
//This class extends to the SetupTests as the SetupTests class contains all the setup requirements to run our test
public void  testLogin() throws InterruptedException
        {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123");

        //Handler for dashboard page
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.clickWelcomeAdmin();
        loginPage = dashboardPage.clickLogout();
        }
}



