package tests.US_008_TestCases;

import org.testng.annotations.Test;
import pages.US_008_page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_0802 {
    @Test
    public void AddRoomReservation() {

        US_008_page us_008_page = new US_008_page();

        Driver.getDriver().get(ConfigReader.getProperty("US_08_ConcortHotelUrl"));
        us_008_page.LoginButonu.click();

        us_008_page.userName.sendKeys(ConfigReader.getProperty("us_08_userName"));
        us_008_page.Password.sendKeys(ConfigReader.getProperty("us_08_Password"));
        us_008_page.Login.click();
        us_008_page.HotelManagement.click();
        us_008_page.RoomReservations.click();
        us_008_page.AddRoomReservation.click();
        Driver.closeDriver();

    }

}
