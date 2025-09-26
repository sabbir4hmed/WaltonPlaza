package Drivers;

import org.openqa.selenium.WebDriver;

public class PageDriver
{
    // ThreadLocal ensures driver is safe for parallel test execution
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    // Set driver
    public static void setDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    // Get driver
    public static WebDriver getCurrentDriver() {
        return webDriver.get();
    }

    // Remove driver (cleanup)
    public static void removeDriver() {
        webDriver.remove();
    }
}
