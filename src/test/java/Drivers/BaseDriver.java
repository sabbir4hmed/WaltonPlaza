package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseDriver {

    public static String browserName = System.getProperty("browser", "chrome");

    public void setup()
    {
        WebDriver driver;

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else {
            throw new RuntimeException("Browser not supported: " + browserName);
        }

        // Set driver configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Set driver in PageDriver
        PageDriver.setDriver(driver);

        // Navigate to application URL
        driver.get("https://waltonplaza.com.bd/");
    }

    public void tearDown() {
        if (PageDriver.getCurrentDriver() != null) {
            PageDriver.getCurrentDriver().quit();
            PageDriver.setDriver(null);
        }
    }

}
