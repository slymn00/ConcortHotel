package tests.US_007_TestCases;

import org.apache.commons.math3.linear.ConjugateGradient;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_007_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0701 extends TestBaseRapor {
    /*
    - ana sayfaya git
    - Login tusuna bas
    - Username gir
    - password gir
    _ logine bas
    - Hotel Managementa tikla
    - Hotel Rooma tıkla
    */
    @Test
    public void hotelRoomTest() {
        US_007_page us_007_page = new US_007_page();

        Driver.getDriver().get(ConfigReader.getProperty("US_007_MainPageUrl"));
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigReader.getProperty("US_007_MainPageTitleText"), "Home Title yazisi cikmiyor ya da ana sayfa gozukmuyor");

        us_007_page.loginBttn.click();
        Assert.assertEquals(Driver.getDriver().getTitle(),ConfigReader.getProperty("US_007_LoginPageTitleText"),"Login page yazisi gelmedi ya da login page acilmadi");

        us_007_page.usernameTextBox.sendKeys(ConfigReader.getProperty("US_007_AdminUsername"));
        Assert.assertTrue(us_007_page.usernameTextBox.isEnabled(),"username yazilmiyor");

        us_007_page.passwordTextBox.sendKeys(ConfigReader.getProperty("US_007_AdminPassword"));
        Assert.assertTrue(us_007_page.passwordTextBox.isEnabled(),"password yazilmiyor");

        us_007_page.loginPageLoginBttn.click();
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigReader.getProperty("US_007_AdminPAgeTitleText"),"Admin sayfasi gozukmedi");

        us_007_page.hotelManagementMenu.click();
        Assert.assertTrue(us_007_page.hotelManagementSubMenu.isDisplayed(),"Hotel Management SubMenu acilmadi");

        us_007_page.HotelRoomsBttn.click();
        Assert.assertTrue(us_007_page.listOfHotelRoomsTitleText.isDisplayed(),"List of Hotel Rooms gozukmuyor");
        Driver.closeDriver();
    }
}
