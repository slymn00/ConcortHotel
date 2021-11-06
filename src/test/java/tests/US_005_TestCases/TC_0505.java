package tests.US_005_TestCases;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_005_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0505 extends TestBaseRapor {
    ExtentTest extentTest;
    @Test
    public void test(){
        //1-Hotel management sekmesi tiklanabilir olmali
        //2-acilan sekmelerden hotel list secilebilir olmali
        //3-title da list of hotels gorulmeli
        //4-details butonuna tiklamali
        //5-delete butonuna tiklamali
        //6-hotelin silindigini gormeli  adana
        Actions actions=new Actions(Driver.getDriver());
        US_005_page us_005_page =new US_005_page();
       extentTest=extentReports.createTest("otel bilgileri guncellenebilir olmali");
        Driver.getDriver().get(ConfigReader.getProperty("US05_concortUrl"));
        extentTest.info("siteye gidildi");
        us_005_page.ConcortHotelLogin();
       extentTest.pass("basarili bir sekilde login olundu");
        us_005_page.hotelManagement.click();
        extentTest.pass("basarili bir sekilde management sekmesine tiklandi");
        us_005_page.hotelList.click();
        extentTest.pass("Hotel list goruntulendi");
        us_005_page.detailsbutonu.click();

        us_005_page.switchToWindow("");
        extentTest.pass("duzenleme sayfasina gecildi");
//actions.sendKeys(Keys.END).perform();
        us_005_page.hotelListDeleteButonu.click();

        us_005_page.htmlDeleteOnay.click();

        Assert.assertTrue(us_005_page.htmlHataYazisi.getText().contains("hotel deleted"));
        extentTest.fail("hotel silinemedi");
    }
}
