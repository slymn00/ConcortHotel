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
        Faker faker = new Faker();
        us_007_page.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigReader.getProperty("US_007_AdminPAgeTitleText"), "Admin sayfasi gozukmedi");
        us_007_page.hotelManagementMenu.click();
        ReusableMethods.waitFor(1);
        us_007_page.hotelManagementSubMenu.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us_007_page.hotelManagementSubMenu.isDisplayed(),"Hotel Management SubMenu acilmadi");
        us_007_page.HotelRoomsBttn.click();
        Assert.assertTrue(us_007_page.listOfHotelRoomsTitleText.isDisplayed(),"List of Hotel Rooms gozukmuyor");
        us_007_page.firstHotelRoomDetailBttn.click();
        Assert.assertEquals(Driver.getDriver().getTitle(),ConfigReader.getProperty("US_007_EditHotelRoomPageTitleText"),"Edit Hotel Room title gozukmuyor");
        Select select = new Select(us_007_page.idHotelDropdownMenu);
        select.selectByVisibleText(ConfigReader.getProperty("US_007_HotelDropDownSelect"));
        ReusableMethods.waitFor(1);
        us_007_page.codeBox.clear();
        us_007_page.nameBox.clear();
        us_007_page.locationBox.clear();
        us_007_page.descriptionTextArea.clear();
        us_007_page.maxAdultCountBox.clear();
        us_007_page.maxChildCountBox.clear();
        ReusableMethods.waitFor(1);
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
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us_007_page.hotelRoomUpdateNotifBox.getText().contains(ConfigReader.getProperty("US_007_HotelRoomUpdatedSuccessText")),"kayit basarisiz");
        Driver.closeDriver();
    }
}
