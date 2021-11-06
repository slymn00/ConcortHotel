package tests.US_007_TestCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_007_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ResourceBundle;

public class TC_0704 extends TestBaseRapor {
    /*
    TC_703
    save
     */
    @Test
    public void saveHotelRoomDataTest(){
        US_007_page us_007_page = new US_007_page();
        extentTest=extentReports.createTest("Detail Test","Hotel Room listesinden Odanın detail kismina gidilmesi testi");
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
        Select select = new Select(us_007_page.idHotelDropdownMenu);
        select.selectByVisibleText(ConfigReader.getProperty("US_007_HotelDropDownSelect"));
        extentTest.info("HotelDropDown menuden yeni bir secim yapildi");
        ReusableMethods.waitFor(1);
        us_007_page.codeBox.clear();
        us_007_page.nameBox.clear();
        us_007_page.locationBox.clear();
        us_007_page.descriptionTextArea.clear();
        us_007_page.maxAdultCountBox.clear();
        us_007_page.maxChildCountBox.clear();
        extentTest.info("var olan datalar clear() ile temizlendi");
        ReusableMethods.waitFor(1);
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
        actions.sendKeys(us_007_page.codeBox, faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("US_007_DescriptionText"))
                .dragAndDrop(us_007_page.dragPrice200, us_007_page.priceBox)
                .perform();
        select = new Select(us_007_page.idGroupRoomTypeDropdownMenu);
        select.selectByVisibleText(ConfigReader.getProperty("US_007_RoomTypeSelect"));
        ReusableMethods.waitFor(1);
        actions.sendKeys(us_007_page.maxAdultCountBox,faker.number().digit())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .click(us_007_page.hotelRoomDataSaveBttn)
                .perform();
        extentTest.info("Datalar guncellendi");
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us_007_page.hotelRoomUpdateNotifBox.getText().contains(ConfigReader.getProperty("US_007_HotelRoomUpdatedSuccessText")),"kayit basarisiz");
        extentTest.pass("save edildi");
        Driver.closeDriver();
    }
}
