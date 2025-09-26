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

public class HomePage {

    @FindBy(linkText = "Login")
    public WebElement loginbutton;

    @Step("Click on the login button")
    public void clickloginbtn() {
        WebDriverWait wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
        loginbutton.click();
        attachScreenshot("login_button_clicked");
        System.out.println("Login button clicked successfully");
    }

    @Attachment(value = "{0}", type = "image/png")
    private byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) PageDriver.getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
    }
}