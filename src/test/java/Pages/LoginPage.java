package Pages;

import Drivers.PageDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    @FindBy(linkText = "Login with Password")
    public WebElement loginWithPasswordLink;

    @FindBy(name = "emailOrPhone")
    public WebElement emailOrPhoneInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(css = "form button[type='submit']") // More robust selector
    public WebElement loginButton;

    @Step("Click on login with password link")
    public void clickonloginwithpassword() {
        WebDriverWait wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(loginWithPasswordLink));
        loginWithPasswordLink.click();
        attachScreenshot("login_with_password_clicked");
        System.out.println("Login with password link clicked");
    }

    @Step("Enter username: {0}")
    public void enterEmailOrPhone(String username) {
        WebDriverWait wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(emailOrPhoneInput));
        emailOrPhoneInput.clear();
        emailOrPhoneInput.sendKeys(username);
        attachScreenshot("entered_username");
        System.out.println("Username entered: " + username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        attachScreenshot("entered_password");
        System.out.println("Password entered successfully");
    }

    @Step("Click on login button")
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        attachScreenshot("login_button_clicked");
        System.out.println("Login button clicked");
    }

    @Attachment(value = "{0}", type = "image/png")
    private byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) PageDriver.getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
