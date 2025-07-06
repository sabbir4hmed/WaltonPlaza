package Pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage
{

    @FindAll(
            {
                    @FindBy(xpath = "//div[@class='Navbar_locationContainer___YJIP']//div[@class='LocationInputOnNavbar_root__XRGTn']"),
                    @FindBy(css = "div[class='Navbar_locationContainer___YJIP'] div[class='LocationInputOnNavbar_root__XRGTn']")
            }
    )

    public WebElement navbarlocationbutton;

    @FindAll(
            {
                    @FindBy(xpath = "//div[contains(text(),'Select Manual Location')]"),
                    @FindBy(css = "div[class='Dropdowns_items__Gjh2w'] div:nth-child(2) div:nth-child(1)")
            }
    )

    public WebElement manuallocationbutton;


    @FindAll(
            {
                    @FindBy(xpath = "//input[@placeholder='Search your Area']"),
                    @FindBy(css = "input[placeholder='Search your Area']")
            }
    )

    public WebElement locationsearch;


    @FindAll(
            {
                    @FindBy(xpath = "//div[contains(text(),'Tangail Sadar, Tangail')]"),
                    @FindBy(css = "div[class='Dropdowns_items__Gjh2w'] div:nth-child(1) div:nth-child(1)")
            }
    )

    public WebElement locationselect;

    @Step("Location Button will be Displayed and Clicked")
    public void locationbutton(WebDriver driver)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(navbarlocationbutton));
            navbarlocationbutton.isDisplayed();
            navbarlocationbutton.click();
            attatchScreenshot(driver, "Location Button is displayed & Clicked");
        } catch (Exception e) {
            try
            {
                attatchScreenshot(driver, "Location Button is not Displayed or Clicked");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }


    @Step("Manual Location Button will be Displayed and Clicked")
    public void clickmanuallocation(WebDriver driver)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(manuallocationbutton));

            manuallocationbutton.isDisplayed();
            manuallocationbutton.click();

            attatchScreenshot(driver, "Manual location button is displayed and clicked");

        } catch (Exception e) {

            try {
                attatchScreenshot(driver, "Manual location button is not displayed and clicked");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }





    @Attachment (value = "This is the test of Location selection from Dashboard", type = "image/png")
    private byte[] attatchScreenshot(WebDriver driver, String dashboardinfo) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


}
