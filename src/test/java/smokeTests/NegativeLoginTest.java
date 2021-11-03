package smokeTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class NegativeLoginTest extends TestBaseRapor {



    @Test(groups = "smoke")
    public void kullaniciAdiVeSifreYanlis(){
        extentTest=extentReports.createTest("Kullanici adi ve sifre yanlis","Concort hotel id ve sifre yanlis giris testi");
        Driver.getDriver().get(ConfigReader.getProperty("chotel_url"));
        extentTest.info("concort hotel sayfasina git");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.firstLoginButton.click();
        extentTest.info("ilk sayfadaki login butonuna tikla");
        logIn_page.usernameBox.sendKeys(ConfigReader.getProperty("chotel_wrong_username"));
        extentTest.info("yanlis kullanici adi gir");
        logIn_page.passwordBox.sendKeys(ConfigReader.getProperty("chotel_wrong_password"));
        extentTest.info("yanlis sifre gir");
        logIn_page.loginButton.click();
        extentTest.info("login butonuna tikla");
        Assert.assertTrue(logIn_page.validationErrorText.isDisplayed());
        extentTest.pass("hata mesaji goruntulendi,Test PASSED");
        Driver.closeDriver();
    }



    @Test(groups = "smoke")
    public void kullaniciAdiDogruSifreYanlis(){
        extentTest=extentReports.createTest("Kullanici adi dogru, sifre yanlis","Concort hotel kullanici adi dogru sifre yanlis testi");
        Driver.getDriver().get(ConfigReader.getProperty("chotel_url"));
        extentTest.info("concort hotel sayfasina git");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.firstLoginButton.click();
        extentTest.info("ilk sayfadaki login butonuna tikla");
        logIn_page.usernameBox.sendKeys(ConfigReader.getProperty("chotel_valid_username"));
        extentTest.info("Dogru kullanici adi gir");
        logIn_page.passwordBox.sendKeys(ConfigReader.getProperty("chotel_wrong_password"));
        extentTest.info("yanlis sifre gir");
        logIn_page.loginButton.click();
        extentTest.info("login butonuna tikla");
        Assert.assertTrue(logIn_page.validationErrorText.isDisplayed());
        extentTest.pass("hata mesaji goruntulendi,Test PASSED");
        Driver.closeDriver();
    }



    @Test(groups = "smoke")
    public void kullaniciAdiYanlisSifreDogru(){
        extentTest=extentReports.createTest("kulanici adi yanlis, sifre dogru","Concort hotel kullanici adi yanlis sifre dogru testi");
        Driver.getDriver().get(ConfigReader.getProperty("chotel_url"));
        extentTest.info("concort hotel sayfasina git");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.firstLoginButton.click();
        extentTest.info("ilk sayfadaki login butonuna tikla");
        logIn_page.usernameBox.sendKeys(ConfigReader.getProperty("chotel_wrong_username"));
        extentTest.info("Yanlis kullanici adi gir");
        logIn_page.passwordBox.sendKeys(ConfigReader.getProperty("chotel_valid_password"));
        extentTest.info("Dogru sifre gir");
        logIn_page.loginButton.click();
        extentTest.info("login butonuna tikla");
        Assert.assertTrue(logIn_page.validationErrorText.isDisplayed());
        extentTest.pass("hata mesaji goruntulendi,Test PASSED");
        Driver.closeDriver();
    }
}
