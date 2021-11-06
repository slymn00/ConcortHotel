package tests.US_008_TestCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_008_page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Date;

public class TC_0801 {
    @Test
    public void room_reservations() throws InterruptedException {
        US_008_page us_008_page=new US_008_page();

        Driver.getDriver().get(ConfigReader.getProperty("US_08_ConcortHotelUrl"));
        us_008_page.LoginButonu.click();

        us_008_page.userName.sendKeys(ConfigReader.getProperty("us_08_userName"));
        us_008_page.Password.sendKeys(ConfigReader.getProperty("us_08_Password"));
        us_008_page.Login.click();
        us_008_page.HotelManagement.click();
        us_008_page.RoomReservations.click();
        Driver.closeDriver();
    }


}
