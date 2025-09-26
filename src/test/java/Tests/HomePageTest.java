package Tests;

import Drivers.BaseDriver;
import Drivers.PageDriver;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseDriver {

        @BeforeMethod
        public  void setupdriver()
        {
            setup();
        }

        @AfterMethod
        public void teardowndriver()
        {
            tearDown();
        }

        @Test(priority = 1)
        @Description("Login Button Test")
        @Severity(SeverityLevel.NORMAL)
        public void testloginbutton()
        {
            WebDriver driver = PageDriver.getCurrentDriver();
            HomePage homePage = PageFactory.initElements(driver, HomePage.class);

            homePage.clickloginbtn(driver);

            String currenturl = driver.getCurrentUrl();

            Assert.assertTrue(currenturl.contains("login") || currenturl.contains("Sign in"),
                    "Login button did not navigate to login page. Current URL: " + currenturl);
        }

}
