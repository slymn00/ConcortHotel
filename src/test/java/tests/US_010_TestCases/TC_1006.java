package tests.US_010_TestCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_010_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_1006 extends TestBaseRapor {
    /*
Reservation was made successfully Your Reservation Link is : here yazısı çıkmalı

1-Kullanici siteye gider
2-Kullanici siteye giriş yapar
3-Home sayfasina gecis yapar
4-Our Room's kismindan ikinci odanin view room details kismina tiklar
5-Gerekli datalari textbox'lara girer
6-Book this room butonuna tiklar
7-Kullanicinin karsisina basarili kayit oldugu yazisi cikar

     */

    @Test
    public void basariliKayitOldunuzYazisiTesti(){
        extentTest=extentReports.createTest("TC_1006_Basarili kayit testi","Kullanici basarili bir sekilde reservasyon kaydini yaptirmali");
        US_010_page us_010_page=new US_010_page();
        us_010_page.login();
        Assert.assertTrue(us_010_page.profileYazisi.isDisplayed());
        extentTest.pass("profile yazisi gorundu, Test PASSED");
        us_010_page.homeButonu.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("us010_chotel_Title_Home_yazisi")));
        extentTest.pass("Title home yazisi iceriyor, Test PASSED");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        ReusableMethods.waitFor(2);
        us_010_page.ikinciOdaDetailsButonu.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("us010_chotel_url_Room_Detail")));
        extentTest.pass("URL roomdetail iceriyor, Test PASSED");
        us_010_page.DateStart.clear();

        actions.sendKeys(us_010_page.DateStart,ConfigReader.getProperty("us010_chotel_date_start"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_date_end"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_Adult_Count"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_Child_Count"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_Name_on_CC"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_CCN"))
                .perform();
        Select CCExpirationYear=new Select(us_010_page.CCExpirationYear);
        CCExpirationYear.selectByVisibleText(ConfigReader.getProperty("us010_chotel_CC_Expiration_Year"));
        Select CCExpirationMonth=new Select(us_010_page.CCExpirationMonth);
        CCExpirationMonth.selectByVisibleText(ConfigReader.getProperty("us010_chotel_CC_Expiration_Month"));
        actions.sendKeys(us_010_page.CVV,ConfigReader.getProperty("us010_chotel_CVV"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_Message"))
                .perform();
        Assert.assertTrue(us_010_page.bookThisRoomButton.isEnabled());
        extentTest.pass("Book this room Butonu aktif, Test PASSED");
        us_010_page.bookThisRoomButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us_010_page.basariliKayitHTMLPopUp.isDisplayed());
        extentTest.pass("Herhangi bir error gorunmuyor, Test PASSED");

        Assert.assertTrue(us_010_page.basariliKayitTexti.isDisplayed());
        extentTest.pass("Basarili kayit texti gorundu, Test PASSED");


    }
}
