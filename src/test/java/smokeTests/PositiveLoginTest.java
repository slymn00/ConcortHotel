package smokeTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;
public class PositiveLoginTest extends TestBaseRapor {



    @Test(groups = "smoke")
    public void positiveSmokeTest(){
        extentTest=extentReports.createTest("Positive giris testi","Concort Hotel dogru kullanici adi ve sifre giris testi");
        Driver.getDriver().get(ConfigReader.getProperty("chotel_url"));
        extentTest.info("Concort hotel adresine git");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.firstLoginButton.click();
        extentTest.info("Ilk login tusuna tikla");
        logIn_page.usernameBox.sendKeys(ConfigReader.getProperty("chotel_valid_username"));
        extentTest.info("Dogru kullanici adini gir");
        logIn_page.passwordBox.sendKeys(ConfigReader.getProperty("chotel_valid_password"));
        extentTest.info("Dogru sifreyi gir");
        logIn_page.loginButton.click();
        extentTest.info("Login butonuna tikla");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("chotel_basarili_giris_url"));
        extentTest.pass("Basarili sekilde giris yapildi, Test PASSED");
        Driver.closeDriver();



    }
}
