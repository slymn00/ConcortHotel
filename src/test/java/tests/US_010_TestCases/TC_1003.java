package tests.US_010_TestCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_010_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_1003 extends TestBaseRapor {
    /*
    Our Rooms'tan oda seçilebilmeli
    1-Kullanici siteye gider
    2-Kullanici siteye giriş yapar
    3-Home sayfasina gecis yapar
    4-Our Room's kismindan ikinci odanin view room details kismina tiklar

     */

    @Test
    public void odaSecebilmeTest(){
        extentTest=extentReports.createTest("TC_1003_Our Rooms'tan oda secilebilmeli","our rooms kismindan ikinci room detail butonuna tiklanmali testi");
        US_010_page us_010_page=new US_010_page();
        us_010_page.login();
        Assert.assertTrue(us_010_page.profileYazisi.isDisplayed());
        extentTest.pass("profile yazisi gorunuyor, Test PASSED");
        us_010_page.homeButonu.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("us010_chotel_Title_Home_yazisi")));
        extentTest.pass("title home yazisi iceriyor, Test PASSED");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        ReusableMethods.waitFor(2);
        us_010_page.ikinciOdaDetailsButonu.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("us010_chotel_url_Room_Detail")));
        extentTest.pass("URL room detail iceriyor, Test PASSED");



    }
}
