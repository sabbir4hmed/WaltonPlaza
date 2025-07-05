package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseDriver {

    WebDriver driver;

    public static String baseurl = "https://waltonplaza.com.bd/";

    @BeforeSuite
    public void startdriver()
    {
        String browser = System.getProperty("browser", "chrome");
        if(browser.contains("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        PageDriver.getInstance().setWebDriver(driver);
    }

    @AfterSuite
    public void closedriver()
    {
        PageDriver.getCurrentDriver().quit();

    }





}
