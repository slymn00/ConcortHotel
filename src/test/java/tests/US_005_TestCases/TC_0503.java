package tests.US_005_TestCases;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_005_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0503 extends TestBaseRapor {
    US_005_page us_005_page=new US_005_page();
   ExtentTest extentTest;
    @Test
    public void test(){
       // extentTest=extentReports.createTest("hotel management sekmesine tiklamali ve hotel listi secmeli");
        //1-Hotel management sekmesi tiklanabilir olmali
        //2-acilan sekmelerden hotel list secilebilir olmali
        //3-title da list of hotels gorulmeli
        Driver.getDriver().get(ConfigReader.getProperty("US05_concortUrl"));
       // extentTest.info("siteye gidildi");
        us_005_page.ConcortHotelLogin();
      //  extentTest.pass("basarili bir sekilde login olundu");
        us_005_page.hotelManagement.click();
      //  extentTest.pass("basarili bir sekilde management sekmesine tiklandi");
        us_005_page.hotelList.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("List Of Hotels"));
       // extentTest.pass("basarili bir sekilde title da List Of Hotels yazisi goruldu");
    }
}
