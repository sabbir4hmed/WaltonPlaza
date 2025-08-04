package Tests;

import Drivers.BaseDriver;
import Drivers.PageDriver;
import Pages.DashboardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DashboardTest extends BaseDriver
{

    @Test(priority = 1)
    @Description("THis is the test of click the location button from navbar")
    @Severity(SeverityLevel.CRITICAL)
    public void clicklocationbutton() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(),dashboardPage);
        dashboardPage.locationbutton(PageDriver.getCurrentDriver());
        Thread.sleep(2000);

    }


    @Test(priority = 2)
    @Description("THis is the test of click the manual location button from dropdown")
    @Severity(SeverityLevel.CRITICAL)
    public void clickmanuallocationbutton() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(),dashboardPage);
        dashboardPage.clickmanuallocation(PageDriver.getCurrentDriver());
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    @Description("THis is the test of show the search location area")
    @Severity(SeverityLevel.CRITICAL)
    public void searchlocationbox() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(),dashboardPage);
        dashboardPage.clicklocationsearcharea(PageDriver.getCurrentDriver());
        Thread.sleep(2000);

    }

    @Test(priority = 4)
    @Description("THis is the test of click the search location area")
    @Severity(SeverityLevel.CRITICAL)
    public void searchlocationselect() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        PageFactory.initElements(PageDriver.getCurrentDriver(),dashboardPage);
        dashboardPage.clicklocationshowbutton(PageDriver.getCurrentDriver());
        Thread.sleep(2000);

    }

}
