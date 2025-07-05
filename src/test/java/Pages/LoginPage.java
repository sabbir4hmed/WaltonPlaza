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

public class LoginPage
{
    @FindAll(
            {
                    @FindBy(name = "phone"),
                    @FindBy(xpath = "//input[@placeholder=' ']")
            }
    )
    public WebElement phoneInput;

    @FindAll(
            {
                    @FindBy(linkText = "Login with Password"),
                    @FindBy(xpath = "//a[normalize-space()='Login with Password']")
            }
    )

    public WebElement loginWithPasswordLink;

    @Step("Verify the login page filed and elements are displayed")
    public void loginpagefield(WebDriver driver)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(phoneInput));
            phoneInput.isDisplayed();
            phoneInput.sendKeys("01622290146");
            attatchScreenshot(driver, "login_page_field_displayed");
        } catch (Exception e) {
            try {
               attatchScreenshot(driver, "login_page_field_not_displayed");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }


    @Step("Click on the login with password Link")
    public void clickonloginwithpassword(WebDriver driver)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(loginWithPasswordLink));
            loginWithPasswordLink.isDisplayed();
            loginWithPasswordLink.click();
            attatchScreenshot(driver, "login_with_password_link_clicked");
        } catch (Exception e) {
            try
            {
                attatchScreenshot(driver, "login_with_password_link_not_clicked");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Attachment(value = "Screenshot of login page field displayed", type = "image/png")
    private byte[] attatchScreenshot(WebDriver driver, String loginPageFieldDisplayed) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


}
