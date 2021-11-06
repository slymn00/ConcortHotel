package tests.US_004_TestCases;

import org.testng.annotations.Test;
import pages.US_004_page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_0402 {
    @Test
    public void test() {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        US_004_page US_004_page = new US_004_page();
        US_004_page.ilkLoginLinki.click();
        US_004_page.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        US_004_page.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        US_004_page.loginButonu.click();
        US_004_page.hotelManagementLinki.click();
        US_004_page.hotelListLink.click();
        US_004_page.addHotelLink.click();
    }
}