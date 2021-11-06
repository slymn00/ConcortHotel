package tests.US_007_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_007_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_0705 extends TestBaseRapor {
    /*
    details
    delete
     */
    @Test
    public void hotelRoomDeleteTest(){
        US_007_page us_007_page = new US_007_page();
        extentTest=extentReports.createTest("TC_705_HotelRoomDeleteTest","Secilen Hotel Room delete edilmeli");
        us_007_page.login();
        extentTest.info("admin olarak login edildi");
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigReader.getProperty("US_007_AdminPAgeTitleText"), "Admin sayfasi gozukmedi");
        us_007_page.hotelManagementMenu.click();
        extentTest.info("Hotel Management Menu tiklandi");
        Assert.assertTrue(us_007_page.hotelManagementSubMenu.isDisplayed(),"Hotel Management SubMenu acilmadi");
        extentTest.pass("Hotel Management alt menuleri acildi");
        us_007_page.HotelRoomsBttn.click();
        extentTest.info("Hotel Rooms tiklandi");
        Assert.assertTrue(us_007_page.listOfHotelRoomsTitleText.isDisplayed(),"List of Hotel Rooms gozukmuyor");
        extentTest.pass("Hotel Room listesi gorunuyor");
        us_007_page.firstHotelRoomDetailBttn.click();
        extentTest.info("Hotel Room details'a basildi");
        Assert.assertEquals(Driver.getDriver().getTitle(),ConfigReader.getProperty("US_007_EditHotelRoomPageTitleText"),"Edit Hotel Room title gozukmuyor");
        extentTest.pass("Hotel Room Edit Data saydasi acildi");
        us_007_page.hotelRoomDetailsDeleteBttn.click();
        extentTest.info("delete bttn basildi");
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us_007_page.hotelRoomUpdateNotifBox.isDisplayed(),"would you like to continue yazisi cikmadi");
        extentTest.pass("delete confirmation notif geldi");
        ReusableMethods.waitFor(1);
        us_007_page.deleteNotifConfirmBttn.click();
        extentTest.info("confirm bttn basildi");
        extentTest.pass("Room silindi");
        Driver.closeDriver();
    }
}
