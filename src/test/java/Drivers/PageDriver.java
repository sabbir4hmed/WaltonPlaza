package Drivers;

import org.openqa.selenium.WebDriver;

public class PageDriver {

    private  static final ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    private  static  volatile PageDriver instance;

    public static  PageDriver getInstance()
    {
        if (instance == null)
        {
            synchronized (PageDriver.class)
            {
                if (instance == null)
                {
                    instance = new PageDriver();
                }
            }
        }

        return instance;
    }

    public WebDriver getWebDriver()
    {
        return webdriver.get();
    }
    public void setWebDriver(WebDriver driver)
    {
        webdriver.set(driver);
        //return driver;
    }
    // Important: Clean up ThreadLocal to prevent memory leaks
    public void removeWebDriver() {
        webdriver.remove();
    }

    public static WebDriver getCurrentDriver() {
        return getInstance().getWebDriver();
    }
    private PageDriver() {
        // Private constructor for singleton
    }

}
