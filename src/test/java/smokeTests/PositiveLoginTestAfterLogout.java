package smokeTests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class PositiveLoginTestAfterLogout extends TestBaseRapor {

    @Test(groups = "smoke")
    public void positiveLoginAfterLogout(){
        extentTest=extentReports.createTest("Concort hotel cikis yapildiktan sonra giris","Basarili bir cikis yapildiktan sonra tekrar basarili bir giris testi");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.login();
        extentTest.info("Basarili bir sekilde giris yap");
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(logIn_page.usernameBoxForExit)
                .click(logIn_page.logOutbutton).perform();
        extentTest.info("Basarili bir sekilde cikis yap");
        logIn_page.logInUsernameAfterLogOut.sendKeys(ConfigReader.getProperty("chotel_valid_username"));
        extentTest.info("Dogru kullanici adini gir");
        logIn_page.logInPasswordAfterLogOut.sendKeys(ConfigReader.getProperty("chotel_valid_password"));
        extentTest.info("Dogru sifreyi gir");
        logIn_page.logInlogInButtonAfterLogOut.click();
        extentTest.info("Login butonuna tikla");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("chotel_basarili_giris_url"));
        extentTest.pass("Cikistan sonra basarili bir sekilde tekrar giris yapildi, Test PASSED");
        Driver.closeDriver();
    }
}
