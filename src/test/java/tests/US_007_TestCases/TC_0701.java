package tests.US_007_TestCases;

import org.apache.commons.math3.linear.ConjugateGradient;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_007_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0701 extends TestBaseRapor {
    /*
    - ana sayfaya git
    - Login tusuna bas
    - Username gir
    - password gir
    _ logine bas
    - Hotel Managementa tikla
    - Hotel Rooma tıkla
    */
    @Test
    public void hotelRoomTest() {
        US_007_page us_007_page = new US_007_page();
        extentTest = extentReports.createTest("Hotel Room Test","Hotel Room Listesinin acilip acilmadigi test ediliyor");
        us_007_page.login();
        extentTest.info("admin olarak login edildi");
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigReader.getProperty("US_007_AdminPAgeTitleText"), "Admin sayfasi gozukmedi");
        extentTest.pass("admin sayfasi acildi");
        us_007_page.hotelManagementMenu.click();
        extentTest.info("Hotel Management Menu tiklandi");
        Assert.assertTrue(us_007_page.hotelManagementSubMenu.isDisplayed(),"Hotel Management SubMenu acilmadi");
        extentTest.pass("Hotel Management alt menuleri acildi");
        us_007_page.HotelRoomsBttn.click();
        extentTest.info("Hotel Rooms tiklandi");
        Assert.assertTrue(us_007_page.listOfHotelRoomsTitleText.isDisplayed(),"List of Hotel Rooms gozukmuyor");
        extentTest.pass("Hotel Room listesi gorunuyor");
        Driver.closeDriver();
    }
}
