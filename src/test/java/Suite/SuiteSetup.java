package Suite;

import Drivers.BaseDriver;
import Drivers.PageDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class SuiteSetup
{
    private static final String BASE_URL = "https://waltonplaza.com.bd/";
    @BeforeSuite
    @Parameters({"browser"})
    public void suiteSetup(String browser) {
        System.out.println("Setting up WebDriver for entire test suite...");
        BaseDriver baseDriver = new BaseDriver();
        baseDriver.setupDriver(browser); // Use the parameterized setup
        System.out.println("Browser opened and navigated to: " + BASE_URL);
    }
    // Overloaded method for default browser (if no parameter provided)
    @BeforeSuite
    public void suiteSetup() {
        System.out.println("Setting up WebDriver for entire test suite with default browser...");
        BaseDriver baseDriver = new BaseDriver();
        baseDriver.setupDriver(); // Use default Chrome
        System.out.println("Browser opened and navigated to: " + BASE_URL);
    }
    @AfterSuite
    public void suiteTearDown() {
        System.out.println("Closing WebDriver after entire test suite...");
        PageDriver.removeDriver();
    }
}
