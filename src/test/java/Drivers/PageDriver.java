package Drivers;

import org.openqa.selenium.WebDriver;

public class PageDriver {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver cannot be null");
        }
        webDriver.set(driver);
    }

    public static WebDriver getCurrentDriver() {
        WebDriver driver = webDriver.get();
        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver has not been initialized. " +
                            "Make sure to call BaseDriver.setup() in @BeforeClass or @BeforeMethod"
            );
        }
        return driver;
    }

    public static void removeDriver() {
        WebDriver driver = webDriver.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error while quitting driver: " + e.getMessage());
            } finally {
                webDriver.remove();
            }
        }
    }

    public static boolean isDriverInitialized() {
        return webDriver.get() != null;
    }
}