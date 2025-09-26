package Tests;

import Drivers.BaseDriver;
import Drivers.PageDriver;
import Pages.DashboardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest {

    private BaseDriver baseDriver;
    private DashboardPage dashboardPage;

    @BeforeClass
    public void setUp() {
        baseDriver = new BaseDriver();
        // Don't initialize WebDriver here - it's done at suite level
        System.out.println("DashboardTest class initialized");
    }

    @BeforeMethod
    public void setUpPage() {
        // Navigate to home page (or dashboard if you have direct URL)
        baseDriver.navigateToHome();

        // Initialize page objects
        dashboardPage = new DashboardPage(PageDriver.getCurrentDriver());
    }

    @Test(priority = 1)
    @Description("Click the location button from navbar")
    @Severity(SeverityLevel.CRITICAL)
    public void clickLocationButton() throws InterruptedException {
        dashboardPage.clickLocationButton(PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    @Description("Click the manual location button from dropdown")
    @Severity(SeverityLevel.CRITICAL)
    public void clickManualLocationButton() throws InterruptedException {
        dashboardPage.clickManualLocation(PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    @Description("Enter Tangail in search location area")
    @Severity(SeverityLevel.CRITICAL)
    public void enterLocationSearch() throws InterruptedException {
        dashboardPage.enterLocation("Tangail", PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    @Description("Select Tangail from location search result")
    @Severity(SeverityLevel.CRITICAL)
    public void selectLocation() throws InterruptedException {
        dashboardPage.selectLocation(PageDriver.getCurrentDriver());
        Thread.sleep(2000);
    }
}