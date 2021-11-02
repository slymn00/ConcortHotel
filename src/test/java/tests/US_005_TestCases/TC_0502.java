package tests.US_005_TestCases;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_005_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0502 extends TestBaseRapor {
    //1-Yonetici Concort Hotel sayfasina gider
    //2-Yonetici sag ustteki login butonuna tiklar
    //3-yonetici isim ve password textboxlarina gecersiz kullanici adi ve sifre
    //girer
    //4-yonetici login butonuna basar
    //5- Username or password is incorrect yazisini gorur
    ExtentTest extentTest;
    @Test
    public void test(){
        US_005_page us_005_page=new US_005_page();
        extentTest=extentReports.createTest("Giriş sayfasına geçersiz kimlik bilgileriyle erişilememelidir");
        Driver.getDriver().get(ConfigReader.getProperty("US05_concortUrl"));
        extentTest.info("siteye gidildi");
        us_005_page.ConcortGecersizHotelLogin();
        extentTest.info("siteye giris yapilamadi");
        Assert.assertTrue(us_005_page.wrongLoginTextElement.isDisplayed());
        extentTest.pass("username or passoword is incorrect goruldu");


    }
}
