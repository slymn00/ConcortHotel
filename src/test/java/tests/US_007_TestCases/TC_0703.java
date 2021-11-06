package tests.US_007_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_007_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0703 extends TestBaseRapor {
    /*
    Login
    HotelManagement
    HotelRooms
    Details
    Güncelle
     */
    @Test
    public void guncellemeTest(){
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
        Assert.assertTrue(us_007_page.idHotelDropdownMenu.isEnabled()
                &&us_007_page.codeBox.isEnabled()
                &&us_007_page.nameBox.isEnabled()
                &&us_007_page.locationBox.isEnabled()
                &&us_007_page.descriptionTextArea.isEnabled()
                &&us_007_page.priceBox.isEnabled()
                &&us_007_page.idGroupRoomTypeDropdownMenu.isEnabled()
                &&us_007_page.maxAdultCountBox.isEnabled()
                &&us_007_page.maxChildCountBox.isEnabled()
                &&us_007_page.isAvailableBox.isEnabled(),"DropMenu Unenabled");
        Driver.closeDriver();
    }
}
