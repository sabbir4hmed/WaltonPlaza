package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseDriver {

    // Add your application URL here
    protected static final String BASE_URL = "https://waltonplaza.com.bd/";

    // Method with browser parameter (no TestNG annotations)
    public void setupDriver(String browser) {
        // Only setup if not already initialized
        if (PageDriver.isDriverInitialized()) {
            System.out.println("WebDriver already initialized, reusing existing instance");
            return;
        }

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                ChromeOptions defaultOptions = new ChromeOptions();
                defaultOptions.addArguments("--disable-blink-features=AutomationControlled");
                defaultOptions.addArguments("--disable-extensions");
                defaultOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(defaultOptions);
        }

        driver.manage().window().maximize();
        PageDriver.setDriver(driver);

        // Navigate to the application URL
        driver.get(BASE_URL);
        System.out.println("WebDriver initialized and navigated to: " + BASE_URL);
    }

    // Overloaded method for default browser
    public void setupDriver() {
        setupDriver("chrome");
    }

    // Keep these methods for backward compatibility but don't use TestNG annotations
    public void setup(String browser) {
        setupDriver(browser);
    }

    public void setup() {
        setupDriver();
    }

    public void tearDown() {
        PageDriver.removeDriver();
    }

    // Utility method to navigate to home page
    public void navigateToHome() {
        if (PageDriver.isDriverInitialized()) {
            PageDriver.getCurrentDriver().get(BASE_URL);
            System.out.println("Navigated back to home page: " + BASE_URL);
        }
    }

    // Utility method to navigate to specific URL
    public void navigateTo(String url) {
        if (PageDriver.isDriverInitialized()) {
            PageDriver.getCurrentDriver().get(url);
            System.out.println("Navigated to: " + url);
        }
    }
}