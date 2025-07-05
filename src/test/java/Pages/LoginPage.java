package Pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
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

import static org.testng.Reporter.log;

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

    @FindAll(
            {
                    @FindBy(xpath = "//input[@name='emailOrPhone']"),
                    @FindBy(name = "emailOrPhone")
            }


    )
    public WebElement emailOrPhoneInput;

    @FindAll(
            {
                    @FindBy(xpath = "//input[@name='password']"),
                    @FindBy(name = "password")
            }
    )

    public WebElement passwordInput;

    @FindAll(
            {
                    @FindBy(xpath = "/html/body/div[1]/main/div[1]/div/form/button[1]"),




            }
    )

    public WebElement loginButton;

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


    @Step("Verify the email or phone input field is displayed")
    public void verifyEmailOrPhoneInput(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(emailOrPhoneInput));
            emailOrPhoneInput.isDisplayed();
            emailOrPhoneInput.sendKeys("01622290146");
            attatchScreenshot(driver, "email_or_phone_input_displayed");
        } catch (Exception e) {
            try {
                attatchScreenshot(driver, "email_or_phone_input_not_displayed");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Step("Verify the password input field is displayed")
    public void verifyPasswordInput(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            passwordInput.isDisplayed();
            passwordInput.sendKeys("S@bbir4hmed");
            attatchScreenshot(driver, "password_input_displayed");
        } catch (Exception e) {
            try {
                attatchScreenshot(driver, "password_input_not_displayed");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Step("Verify the login button is displayed and clickable")
    public void verifyLoginButton(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.isDisplayed();
            loginButton.click();
            attatchScreenshot(driver, "login_button_clicked");
        } catch (Exception e) {
            try {
                attatchScreenshot(driver, "login_button_not_clicked");
                log("login_button_not_clicked");
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
