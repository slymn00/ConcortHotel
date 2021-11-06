package tests.US_007_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_007_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0702 extends TestBaseRapor {
    /*
    Login ol
    Hotel management
    Hotel Rooms
    Details
     */
    @Test
    public void detailsTest() {
        US_007_page us_007_page = new US_007_page();
        us_007_page.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigReader.getProperty("US_007_AdminPAgeTitleText"), "Admin sayfasi gozukmedi");
        us_007_page.hotelManagementMenu.click();
        us_007_page.hotelManagementSubMenu.click();
        Assert.assertTrue(us_007_page.hotelManagementSubMenu.isDisplayed(),"Hotel Management SubMenu acilmadi");
        us_007_page.HotelRoomsBttn.click();
        Assert.assertTrue(us_007_page.listOfHotelRoomsTitleText.isDisplayed(),"List of Hotel Rooms gozukmuyor");
        us_007_page.firstHotelRoomDetailBttn.click();
        Assert.assertEquals(Driver.getDriver().getTitle(),ConfigReader.getProperty("US_007_EditHotelRoomPageTitleText"),"Edit Hotel Room title gozukmuyor");

    }
}
