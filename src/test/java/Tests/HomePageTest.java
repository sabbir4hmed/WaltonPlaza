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
import org.testng.annotations.*;

public class HomePageTest {

    private BaseDriver baseDriver;
    private HomePage homePage;

    @BeforeClass
    public void setupClass() {
        baseDriver = new BaseDriver();
        // Don't initialize WebDriver here - it's done at suite level
        System.out.println("HomePageTest class initialized");
    }

    @BeforeMethod
    public void setupMethod() {
        // Navigate to home page before each test method
        baseDriver.navigateToHome();

        // Initialize page objects
        WebDriver driver = PageDriver.getCurrentDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test(priority = 1)
    @Description("Login Button Test")
    @Severity(SeverityLevel.NORMAL)
    public void testloginbutton() throws InterruptedException {
        WebDriver driver = PageDriver.getCurrentDriver();

        homePage.clickloginbtn();

        String currenturl = driver.getCurrentUrl();

        Assert.assertTrue(currenturl.contains("login") || currenturl.contains("Sign in"),
                "Login button did not navigate to login page. Current URL: " + currenturl);

        Thread.sleep(2000);
    }
}