package tests.US_004_TestCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.US_004_page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_0404 {
    @Test
    public void test() {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        US_004_page US_004_page = new US_004_page();
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        US_004_page.ilkLoginLinki.click();
        US_004_page.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        US_004_page.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        US_004_page.loginButonu.click();
        US_004_page.hotelManagementLinki.click();
        US_004_page.hotelListLink.click();
        US_004_page.addHotelLink.click();
        actions.
                click(US_004_page.addHotelCodeKutusu).
                sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                perform();
        Select select = new Select(US_004_page.addHotelDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddHotelDropdownOption"));
        actions.sendKeys(Keys.PAGE_DOWN);
        US_004_page.addHotelSave.click();



    }
}

