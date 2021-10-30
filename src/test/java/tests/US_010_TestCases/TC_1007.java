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

public class TC_1007 extends TestBaseRapor {

    /*
    Here linki çalışmalı
    1-Kullanici siteye gider
    2-Kullanici siteye giriş yapar
    3-Home sayfasina gecis yapar
    4-Our Room's kismindan ikinci odanin view room details kismina tiklar
    5-Gerekli datalari textbox'lara girer
    6-Book this room butonuna tiklar
    7-Kullanicinin karsisina basarili kayit oldugu yazisi cikar
    8-Kullanici karsisina cikan 'Your Reservation Link is: here' bolumunde here botununa tiklar
     */

    @Test
    public void hereLinkiTesti(){
        extentTest=extentReports.createTest("TC_1007_Here linkine tiklanmali","here linkine tiklayip dogru sayfaya yonlendirildigini test etmeli");
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
        us_010_page.hereLinki.click();
        ReusableMethods.waitFor(2);

        Assert.assertEquals(us_010_page.reservationDetailsYazisi.getText(),ConfigReader.getProperty("us010_chotel_Reservasyon_Yazisi"));
        extentTest.pass("Here bolumune tiklandi ve Reservation Details yazisi gorundu, Test PASSED");



    }

}
