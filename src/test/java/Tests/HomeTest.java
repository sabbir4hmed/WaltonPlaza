package Tests;

import Drivers.BaseDriver;
import Drivers.PageDriver;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends BaseDriver {

    @BeforeClass
    public void starturl() throws InterruptedException {
        PageDriver.getCurrentDriver().get(baseurl);
        PageDriver.getCurrentDriver().manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test
    @Description ("This is a test for the home page login button")
    @Severity(SeverityLevel.NORMAL)
    public void Homepagetest() throws InterruptedException {
        HomePage homePage = new HomePage();
        PageFactory.initElements(PageDriver.getCurrentDriver(), homePage);
        homePage.clickloginbtn(PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }

    @AfterClass
    public void afterclass()
    {


    }
}
