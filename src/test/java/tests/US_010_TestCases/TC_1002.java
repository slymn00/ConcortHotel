package tests.US_010_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_010_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_1002 extends TestBaseRapor {
/*

Home giriş yapılabilmeli
1-Kullanici siteye gider
2-Kullanici siteye giriş yapar
3-Ust sekmede bulunan "Home" yazisina tiklar
4-Kullanici Home'a giris yapmıs olur
 */

    @Test
    public void homeSayfasinaGirisTesti(){
        extentTest=extentReports.createTest("TC_1002_Home giris yapabilmeli","Kullanici giris yapip home sayfasina gecis yapabiliyor mu testi");
        US_010_page us_010_page=new US_010_page();
        us_010_page.login();
        Assert.assertTrue(us_010_page.profileYazisi.isDisplayed());
        extentTest.pass("profile yazisi gorunuyor, Test PASSED");
        Assert.assertTrue(us_010_page.homeButonu.isEnabled());
        extentTest.pass("home butonu aktif, Test PASSED");
        us_010_page.homeButonu.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("us010_chotel_Title_Home_yazisi")));
        extentTest.pass("title Home kelimesi iceriyor, Test PASSED");

    }




}
