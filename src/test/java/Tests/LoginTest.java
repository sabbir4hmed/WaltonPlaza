package Tests;

import Drivers.BaseDriver;
import Drivers.PageDriver;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class LoginTest {

    private BaseDriver baseDriver;
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void init() {
        baseDriver = new BaseDriver();
        // Don't initialize WebDriver here - it's done at suite level
        System.out.println("LoginTest class initialized");
    }

    @BeforeMethod
    public void setupMethod() {
        // Navigate to home page before each test method
        baseDriver.navigateToHome();

        // Initialize page objects
        homePage = PageFactory.initElements(PageDriver.getCurrentDriver(), HomePage.class);
        loginPage = PageFactory.initElements(PageDriver.getCurrentDriver(), LoginPage.class);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"01622290146", "S@bbir4hmed"},
                {"01812345678", "AnotherPassword"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) throws InterruptedException {
        try {
            System.out.println("Starting login test with username: " + username);

            homePage.clickloginbtn();
            Thread.sleep(1000); // Wait for navigation

            loginPage.clickonloginwithpassword();
            Thread.sleep(1000); // Wait for form to appear

            loginPage.enterEmailOrPhone(username);
            Thread.sleep(500);

            loginPage.enterPassword(password);
            Thread.sleep(500);

            loginPage.clickLoginButton();
            Thread.sleep(2000); // Wait for login to complete

            System.out.println("Login test completed for username: " + username);

        } catch (Exception e) {
            System.err.println("Login test failed for username: " + username + " - " + e.getMessage());
            throw e;
        }
    }
}