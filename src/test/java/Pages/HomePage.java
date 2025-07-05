package Pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class HomePage {



    @FindAll(
            {
                    @FindBy(linkText = "Login")
            }
    )
    public WebElement loginbutton;

    @Step("Click on the login button")
    public void clickloginbtn(WebDriver driver)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
            loginbutton.isDisplayed();
            loginbutton.click();
            attatchScreenshot(driver, "loginbutton_click");

            File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File destinationfile = new File("screenshots/loginbutton_pass.png");
            Files.createDirectories(destinationfile.getParentFile().toPath());
            Files.copy(sourcefile.toPath(), destinationfile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            Reporter.log("Login button clicked successfully. Screenshot saved at: " + destinationfile.getAbsolutePath(), true);
            Assert.assertTrue(loginbutton.isDisplayed());

        } catch (Exception e) {
            try {
                File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                File destinationfile = new File("screenshots/loginbutton_fail.png");
                Files.createDirectories(destinationfile.getParentFile().toPath());
                Files.copy(sourcefile.toPath(), destinationfile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                attatchScreenshot(driver, "loginbutton_click_fail");
                Reporter.log("Login button click failed or not displayed. Screenshot saved at: " + destinationfile.getAbsolutePath(),true);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    @Attachment(value = "screenshotname", type = "image/png")
    private byte[] attatchScreenshot(WebDriver driver, String screenshotname) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


}
