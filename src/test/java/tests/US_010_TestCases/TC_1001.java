package tests.US_010_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_010_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_1001 extends TestBaseRapor {
    /*
    Kullanici login edebilme
    1-Kullanici Concort Hotel sayfasina gider
    2-Kullanici sag ustteki login butonuna tiklar
    3-Kullanici acilan menude username textboxa tiklar ve username datasini yazar
    4-Kullanici acilan menude password textboxa tiklar ve password datasini yazar
    5-Kullanici login butonuna basar
    6- Login islemi gerceklestirilmis olur.
     */

    @Test
    public void kullanici_login_test(){
        extentTest=extentReports.createTest("TC_1001_Kullanici login edebilme","Kullanici login yapip profiline gelebilmeli");
        US_010_page us_010_page=new US_010_page();
        Driver.getDriver().get(ConfigReader.getProperty("us010_chotel_url"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("us010_chotel_Title_Home_yazisi")));
        extentTest.pass("title home yazisi iceriyor, Test PASSED");
        us_010_page.homeLogin.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("us010_chotel_Title_Login_yazisi")));
        extentTest.pass("title login yazisi iceriyor, Test PASSED");
        us_010_page.usernameTextBox.sendKeys(ConfigReader.getProperty("us010_chotel_username"));
        Assert.assertTrue(us_010_page.usernameTextBox.isEnabled());
        extentTest.pass("username box aktif yazi yazilabilir, Test PASSED");
        us_010_page.passwordTextBox.sendKeys(ConfigReader.getProperty("us010_chotel_password"));
        Assert.assertTrue(us_010_page.passwordTextBox.isEnabled());
        extentTest.pass("password box aktif yazi yazilabilir, Test PASSED");
        Assert.assertTrue(us_010_page.loginButonu.isEnabled());
        extentTest.pass("login butonu aktif, Test PASSED");
        us_010_page.loginButonu.click();
        Assert.assertTrue(us_010_page.profileYazisi.isDisplayed());
        extentTest.pass("profile yazisi gorunuyor, Test PASSED");




    }
}
