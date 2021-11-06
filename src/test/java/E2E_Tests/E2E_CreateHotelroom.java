package E2E_Tests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class E2E_CreateHotelroom extends TestBaseRapor {


    @Test(groups = "e2e")
    public void e2e_addRoom() throws InterruptedException {
        extentTest=extentReports.createTest("Hotel room ekleme","Hotel room eklenebildigini test et, Ardindan tekrardan hotel rooms sayfasina gidip 'List Of Hotelrooms' yazisinin gorunurlugunu test et");
        LogIn_Page logIn_page=new LogIn_Page();

        logIn_page.login();
        extentTest.info("Basarili bir giris yapildi");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("chotel_basarili_giris_url"));
        extentTest.pass("Basarili giris yapildi, Test PASSED");

        logIn_page.hotelManagement.click();
        logIn_page.hotelRoom.click();

        logIn_page.addHotelroom.click();
        extentTest.info("Hotel management, ardindan Hotel room en sonda Add hotelroom tikla");

        Thread.sleep(3000);
        Select select=new Select(logIn_page.addHotelroomIdDdown);
        select.selectByVisibleText(ConfigReader.getProperty("chotel_createHotelroomidHotelDdown"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(logIn_page.addHotelroomCode,ConfigReader.getProperty("chotel_code"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_customer_name"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_customer_adress"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_room_text"))
                .dragAndDrop(logIn_page.addHotelroom400,logIn_page.addHotelroomPrice).perform();
        Select se=new Select(logIn_page.addHotelroomRoomTypeDdown);
        se.selectByVisibleText(ConfigReader.getProperty("chotel_room_type_creation"));
        logIn_page.addHotelroomMaxAdultCount.sendKeys(ConfigReader.getProperty("chotel_adult_count"));
        logIn_page.addHotelroomMaxChildCount.sendKeys(ConfigReader.getProperty("chotel_child_count"));
        extentTest.info("Gerekli bilgileri gir");
        logIn_page.addHotelroomSaveButton.click();
        extentTest.info("Save butonuna tikla");

        Thread.sleep(1000);
        Assert.assertTrue(logIn_page.addHotelroomSuccessfullySaveText.isDisplayed());
        extentTest.pass("Basarili kayit yazisi goruldu, Test PASSED");

        logIn_page.addHotelroomLastOk.click();
        extentTest.info("Ok butonuna tikla");

        actions.sendKeys(Keys.HOME).perform();
        logIn_page.hotelRoom.click();
        extentTest.info("Hotel room'a tikla");

        Assert.assertTrue(logIn_page.listOfHotelroomsText.isDisplayed());
        extentTest.pass("List of Hotelrooms yazisi goruldu, Test PASSED");

        Driver.closeDriver();




    }
}
