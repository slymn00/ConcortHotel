package tests.US_006_TestCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_006_page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_0602 {
    @Test
    public void positiveAddRoomTest() throws InterruptedException {



        US_006_page qaConcortPage = new US_006_page();
        qaConcortPage.LoginMethod();
        qaConcortPage.hotelManage.click();
        qaConcortPage.hotelRoom.click();
        qaConcortPage.addHotelRoom.click();
        Select select = new Select(qaConcortPage.addRoomIdDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("us06AddRoomIdHotel"));

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String name=faker.name().fullName();
        actions.sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(name).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.TAB).sendKeys(faker.lorem().paragraph()).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("us06RoomPrice")).perform();

        select = new Select(qaConcortPage.roomTypeDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("us06RoomType"));

        actions.sendKeys(Keys.TAB).sendKeys(String.valueOf(faker.number().numberBetween(1,2))).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(0,10))).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
        Thread.sleep(3000);
        qaConcortPage.saveButton.click();

        Thread.sleep(5000);
        Assert.assertTrue(qaConcortPage.kaydedildiYazisi.isDisplayed());
        Thread.sleep(5000);
        qaConcortPage.clickButonu.click();
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(2000);
        qaConcortPage.addRoomHome.click();
        Assert.assertTrue(qaConcortPage.addRoomListYazisi.isDisplayed());

        qaConcortPage.selectHotel.sendKeys(ConfigReader.getProperty("us06AddRoomIdHotel"));
        qaConcortPage.selectRoomType.sendKeys(ConfigReader.getProperty("us06RoomType"));
        qaConcortPage.addRoomName.sendKeys(name);
        qaConcortPage.addRoomSearchButton.click();
        String expectedFoundYazisi ="|Found total 1 records";
        Thread.sleep(5000);
        String actualFoundYazisi =qaConcortPage.addRoomFoundYazisi.getText();

        Assert.assertEquals(actualFoundYazisi,expectedFoundYazisi,"aranilan isimde otel odasi bulunamadi");

        Driver.closeDriver();
    }
}
