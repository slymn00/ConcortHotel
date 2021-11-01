package tests.US_005_TestCases;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_005_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0501 extends TestBaseRapor {
    //1-Yonetici Concort Hotel sayfasina gider
    //2-Yonetici sag ustteki login butonuna tiklar
    //3-yonetici isim ve password textboxlarina dogru kullanici adi ve sifre
    //girer
    //4-yonetici login butonuna basar
    //5- title in admin yazisi icerdigini gorur.
        US_005_page us_005_page=new US_005_page();
        ExtentTest extentTest;
        @Test
    public void test(){
            extentTest=extentReports.createTest("TC01_yonetici login edebilme");

            Driver.getDriver().get(ConfigReader.getProperty("US05_concortUrl"));
            extentTest.info("siteye gidildi");
            us_005_page.ConcortHotelLogin();
            extentTest.pass("basarili bir sekilde login olundu");
            Assert.assertTrue(Driver.getDriver().getTitle().contains("Admin"));
            extentTest.pass("ttile admin textini iceriyor");
            Driver.closeDriver();
        }
}
