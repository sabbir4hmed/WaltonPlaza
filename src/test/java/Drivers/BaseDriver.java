package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
        else if (browser.contains(("edge")))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        PageDriver.getInstance().setWebDriver(driver);
    }

    @AfterSuite
    public void closedriver()
    {
        PageDriver.getCurrentDriver().quit();

    }





}
