package tests.US_006_TestCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_006_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0606 extends TestBaseRapor{
    US_006_page qaConcortPage = new US_006_page();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();

    @Test (priority = 1)
    public void negativeTestYetiskinSayisi() throws InterruptedException {

        qaConcortPage.LoginMethod();
        qaConcortPage.hotelManage.click();
        qaConcortPage.hotelRoom.click();
        qaConcortPage.addHotelRoom.click();
        Select select = new Select(qaConcortPage.addRoomIdDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("us06AddRoomIdHotel"));

        actions.sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.TAB).sendKeys(faker.lorem().paragraph()).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("us06RoomPrice"))
                .perform();

        select = new Select(qaConcortPage.roomTypeDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("us06RoomType"));

        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(0, 10))).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
        Thread.sleep(3000);
        qaConcortPage.saveButton.click();


        softAssert.assertTrue(
                qaConcortPage.addRoomCreatYazisi.getText().contains(
                        ConfigReader.getProperty("us06CreateYazisi")), "Create yazisi bulunamadi");


    }

    @Test(priority = 2)
    public void negativeTestCocukSayisi() throws InterruptedException {
        actions.sendKeys(Keys.HOME).perform();
        Select select = new Select(qaConcortPage.addRoomIdDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("us06AddRoomIdHotelFake"));

        actions.sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(Keys.CLEAR).sendKeys(faker.name().fullName()).sendKeys(Keys.TAB)
                .sendKeys(Keys.CLEAR).sendKeys(faker.address().fullAddress())
                .perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).sendKeys(faker.lorem().paragraph()).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB).sendKeys(Keys.CLEAR)
                .sendKeys(ConfigReader.getProperty("us06RoomPrice")).perform();
        select = new Select(qaConcortPage.roomTypeDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("us06RoomType2"));

        actions.sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).sendKeys(String.valueOf(faker.number().numberBetween(1,2)))
                .perform();
        Driver.getDriver().findElement(By.xpath("//input[@placeholder='Children count']")).clear();

        Thread.sleep(3000);
        qaConcortPage.saveButton.click();

        actions.sendKeys(Keys.HOME).perform();
        softAssert.assertTrue(
                qaConcortPage.addRoomCreatYazisi.getText().contains(
                        ConfigReader.getProperty("us06CreateYazisi")),"Create yazisi bulunamadi");



    }
   @Test(priority = 3)
    public void negativeTestApprovedButonu() throws InterruptedException {

        Select select = new Select(qaConcortPage.addRoomIdDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("us06AddRoomIdHotel"));

        actions.sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(Keys.CLEAR).sendKeys(faker.name().fullName()).sendKeys(Keys.TAB)
                .sendKeys(Keys.CLEAR).sendKeys(faker.address().fullAddress())
                .perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).sendKeys(faker.lorem().paragraph()).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB).sendKeys(Keys.CLEAR)
                .sendKeys(ConfigReader.getProperty("us06RoomPrice")).perform();
        select = new Select(qaConcortPage.roomTypeDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("us06RoomType"));

        actions.sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).sendKeys(String.valueOf(faker.number().numberBetween(1,2)))
                .sendKeys(Keys.TAB).sendKeys(Keys.CLEAR)
                .sendKeys(String.valueOf(faker.number().numberBetween(0, 10)))
                .sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .perform();
        Thread.sleep(3000);
        qaConcortPage.saveButton.click();

        String expectedYazisi = "HotelRoom was inserted unsuccessfully";
        String actualKaydedildiYazisi=qaConcortPage.kaydedildiYazisi.getText();
       System.out.println(actualKaydedildiYazisi);
        softAssert.assertEquals(
                actualKaydedildiYazisi,expectedYazisi,"yazilar eslesmiyor");

            softAssert.assertAll();
            Driver.closeDriver();

    }

}
