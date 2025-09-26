package Tests;

import Drivers.BaseDriver;
import Drivers.PageDriver;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {

    @Test (priority = 1)
    @Description("Login with Password Button Clicked")
    @Severity(SeverityLevel.NORMAL)
    public void testloginwithpasswordbutton() {
        WebDriver driver = PageDriver.getCurrentDriver();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.clickonloginwithpassword(driver);
        String currenturl = driver.getCurrentUrl();
        Assert.assertTrue(currenturl.contains("Login with Password")||currenturl.contains("Login with Email and Password"),
                "");

    }


    public Object[][] getlogindata()
    {

        return new Object[][]
                {
                        {"01622290146", "S@bbir4hmed", true  },
                        {"01622290146", "Password123", false },
                        {"01455879546", "", false}
                };

    }

    public void testlogin(String username, String password, boolean expectedresult)
    {
        WebDriver driver = PageDriver.getCurrentDriver();

        LoginPage page = PageFactory.initElements(driver, LoginPage.class);
        page.verifyEmailOrPhoneInput(driver);
        page.emailOrPhoneInput.clear();
        page.emailOrPhoneInput.sendKeys(username);


    }


}
