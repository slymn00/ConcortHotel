package tests.US_005_TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.US_005_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0504 extends TestBaseRapor {
    ExtentTest extentTest;
    @Test
    public void test(){
        Actions actions=new Actions(Driver.getDriver());
        //1-Hotel code u duzeltilebilir/degistirilebilir olmali
        //2-Hotel ismi duzeltilebilir/degistirilebilir olmali
        //3-Adress bilgileri duzeltilebilir/degistirilebilir olmali
        //4-Phone bilgileri duzeltilebilir/degistirilebilir olmali
        //5- E-posta duzeltilebilir/degistirilebilir olmali
        //6-Hotel tipi duzeltilebilir/degistirilebilir olmali
        //7-save butonuna basilmali
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
        us_005_page.codeKutusu.click();
        actions.sendKeys("124")
                .sendKeys(Keys.TAB)
                .sendKeys("nane")
                .sendKeys(Keys.TAB)
                .sendKeys(" basra")
                .sendKeys(Keys.TAB)
                .sendKeys( " 964")
                .sendKeys(Keys.TAB)
                .sendKeys(" yeni_email")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.PAGE_DOWN)
                .click(us_005_page.hotelListsaveButonu).perform();
        extentTest.pass("Bilgiler teker teker duzenlenebildi");




    }
}
