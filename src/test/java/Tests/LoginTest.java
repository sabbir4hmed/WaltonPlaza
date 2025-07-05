package Tests;

import Drivers.BaseDriver;
import Drivers.PageDriver;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {
    @Test
    @Description("This is a test for the login functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(), loginPage);
        loginPage.loginpagefield(PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }

    @Test
    @Description("This is a test for clicking on the login with password link")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(), loginPage);
        loginPage.clickonloginwithpassword(PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }


}
