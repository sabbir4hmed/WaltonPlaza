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
    @Test(priority = 1)
    @Description("This is a test for the login functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(), loginPage);
        loginPage.loginpagefield(PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    @Description("This is a test for clicking on the login with password link")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(), loginPage);
        loginPage.clickonloginwithpassword(PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }

    @Test (priority = 3)
    @Description("This is a test for the phone or mail input field")
    @Severity(SeverityLevel.CRITICAL)
    public void phoneemailtest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(), loginPage);
        loginPage.verifyEmailOrPhoneInput(PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    @Description("This is a test for the password input field")
    @Severity(SeverityLevel.CRITICAL)
    public void passwordfieldtest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(), loginPage);
        loginPage.verifyPasswordInput(PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }

    @Test (priority = 5)
    @Description("This is a test for the login button")
    @Severity(SeverityLevel.CRITICAL)
    public void loginbuttontest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(), loginPage);
        loginPage.verifyLoginButton(PageDriver.getCurrentDriver());
        Thread.sleep(4000);
    }



}
