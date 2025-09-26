package Pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased timeout
        PageFactory.initElements(driver, this);
    }

    @FindAll({
            @FindBy(xpath = "//div[@class='Navbar_locationContainer___YJIP']//div[@class='LocationInputOnNavbar_root__XRGTn']"),
            @FindBy(css = "div[class='Navbar_locationContainer___YJIP'] div[class='LocationInputOnNavbar_root__XRGTn']")
    })
    public WebElement navbarlocationbutton;

    @FindAll({
            @FindBy(xpath = "//div[contains(text(),'Select Manual Location')]"),
            @FindBy(css = "div[class='Dropdowns_items__Gjh2w'] div:nth-child(2) div:nth-child(1)")
    })
    public WebElement manuallocationbutton;

    @FindAll({
            @FindBy(xpath = "//input[@placeholder='Search your Area']"),
            @FindBy(css = "input[placeholder='Search your Area']")
    })
    public WebElement locationsearch;

    @FindAll({
            @FindBy(xpath = "//div[contains(text(),'Tangail Sadar, Tangail')]"),
            @FindBy(css = "div[class='Dropdowns_items__Gjh2w'] div:nth-child(1) div:nth-child(1)")
    })
    public WebElement locationselect;

    @Step("Clicking on location button")
    public void clickLocationButton(WebDriver currentDriver) {
        clickElement(navbarlocationbutton, "Location Button is displayed & Clicked", "Location Button is not displayed");
    }

    @Step("Clicking on manual location button")
    public void clickManualLocation(WebDriver currentDriver) {
        clickElement(manuallocationbutton, "Manual Location button clicked", "Manual Location button is not clicked");
    }

    @Step("Entering location in search box")
    public void enterLocation(String location, WebDriver currentDriver) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locationsearch));
            locationsearch.clear();
            locationsearch.sendKeys(location);
            attachScreenshot("Location entered: " + location);
            logger.info("Location entered: {}", location);
        } catch (Exception e) {
            attachScreenshot("Failed to enter location: " + location);
            logger.error("Failed to enter location: {}", location, e);
            throw new RuntimeException("Failed to enter location: " + location, e);
        }
    }

    @Step("Selecting Tangail from search result")
    public void selectLocation(WebDriver currentDriver) {
        clickElement(locationselect, "Tangail location selected", "Tangail location not selected");
    }

    // Common reusable click method
    private void clickElement(WebElement element, String successMsg, String failMsg) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            attachScreenshot(successMsg);
            logger.info(successMsg);
        } catch (Exception e) {
            attachScreenshot(failMsg);
            logger.error(failMsg, e);
            throw new RuntimeException(failMsg, e);
        }
    }

    @Attachment(value = "{0}", type = "image/png")
    private byte[] attachScreenshot(String message) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}