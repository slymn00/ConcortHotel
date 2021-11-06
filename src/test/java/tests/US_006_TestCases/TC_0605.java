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

public class TC_0605 {
    US_006_page qaConcortPage = new US_006_page();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void negativeTestFiyat() throws InterruptedException {

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
                .perform();

        select = new Select(qaConcortPage.roomTypeDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("us06RoomType"));

        actions.sendKeys(Keys.TAB).sendKeys(String.valueOf(faker.number().numberBetween(1, 2))).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(0, 10))).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
        Thread.sleep(3000);
        qaConcortPage.saveButton.click();

        actions.sendKeys(Keys.HOME).perform();
        softAssert.assertTrue(
                qaConcortPage.addRoomCreatYazisi.getText().contains(
                        ConfigReader.getProperty("us06CreateYazisi")), "Create yazisi bulunamadi");


    }

    @Test(dependsOnMethods = "negativeTestFiyat")
    public void negativeTestRoomType() throws InterruptedException {

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
        select.selectByVisibleText(ConfigReader.getProperty("us06RoomTypeFake"));

        actions.sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).sendKeys(String.valueOf(faker.number().numberBetween(1,2)))
                .sendKeys(Keys.TAB).sendKeys(Keys.CLEAR)
                .sendKeys(String.valueOf(faker.number().numberBetween(0,10))).sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(3000);
        qaConcortPage.saveButton.click();

        actions.sendKeys(Keys.HOME).perform();
        softAssert.assertTrue(
                qaConcortPage.addRoomCreatYazisi.getText().contains(
                        ConfigReader.getProperty("us06CreateYazisi")),"Create yazisi bulunamadi");
        softAssert.assertAll();

        Driver.closeDriver();
    }

}
