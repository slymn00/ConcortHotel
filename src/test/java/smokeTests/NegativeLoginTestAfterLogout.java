package smokeTests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class NegativeLoginTestAfterLogout extends TestBaseRapor {

    @Test(groups = "smoke")
    public void wrongIdCorrectPassword(){
        extentTest=extentReports.createTest("Cikis yapildiktan sonra, negative giris","Basarili bir giristen sonra cikis yaptiktan sonraki basarisiz giris testi, yanlis kullanici adi ,dogru password");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.login();
        extentTest.info("Siteye basarili giris yap");
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(logIn_page.usernameBoxForExit)
                .click(logIn_page.logOutbutton).perform();
        extentTest.info("Basarili giristen sonra cikis yap");
        logIn_page.logInUsernameAfterLogOut.sendKeys(ConfigReader.getProperty("chotel_wrong_username"));
        extentTest.info("Yanlis kullanici adi gir");
        logIn_page.logInPasswordAfterLogOut.sendKeys(ConfigReader.getProperty("chotel_valid_password"));
        extentTest.info("Dogru password gir");
        logIn_page.logInlogInButtonAfterLogOut.click();
        extentTest.info("Login butonuna tikla");
        Assert.assertTrue(logIn_page.logInErrorAfterLogout.isDisplayed());
        extentTest.pass("Hata mesaji goruntulendi giris yapilamiyor, TEST PASSED");
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void correctIdWrongPassword(){
        extentTest=extentReports.createTest("Cikis yapildiktan sonra, negative giris","Basarili bir giristen sonra cikis yaptiktan sonraki basarisiz giris testi, dogru kullanici adi ,yanlis password");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.login();
        extentTest.info("Siteye basarili giris yap");
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(logIn_page.usernameBoxForExit)
                .click(logIn_page.logOutbutton).perform();
        extentTest.info("Basarili giristen sonra cikis yap");
        logIn_page.logInUsernameAfterLogOut.sendKeys(ConfigReader.getProperty("chotel_valid_username"));
        extentTest.info("Dogru kullanici adi gir");
        logIn_page.logInPasswordAfterLogOut.sendKeys(ConfigReader.getProperty("chotel_wrong_password"));
        extentTest.info("Yanlis password gir");
        logIn_page.logInlogInButtonAfterLogOut.click();
        extentTest.info("Login butonuna tikla");
        Assert.assertTrue(logIn_page.logInErrorAfterLogout.isDisplayed());
        extentTest.pass("Hata mesaji goruntulendi giris yapilamiyor, TEST PASSED");
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void wrongIdWrongPassword(){
        extentTest=extentReports.createTest("Cikis yapildiktan sonra, negative giris","Basarili bir giristen sonra cikis yaptiktan sonraki basarisiz giris testi, yanlis kullanici adi ,yanlis password");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.login();
        extentTest.info("Siteye basarili giris yap");
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(logIn_page.usernameBoxForExit)
                .click(logIn_page.logOutbutton).perform();
        extentTest.info("Basarili giristen sonra cikis yap");
        logIn_page.logInUsernameAfterLogOut.sendKeys(ConfigReader.getProperty("chotel_wrong_username"));
        extentTest.info("Yanlis kullanici adi gir");
        logIn_page.logInPasswordAfterLogOut.sendKeys(ConfigReader.getProperty("chotel_wrong_password"));
        extentTest.info("Yanlis password gir");
        logIn_page.logInlogInButtonAfterLogOut.click();
        extentTest.info("Login butonuna tikla");
        Assert.assertTrue(logIn_page.logInErrorAfterLogout.isDisplayed());
        extentTest.pass("Hata mesaji goruntulendi giris yapilamiyor, TEST PASSED");
        Driver.closeDriver();
    }
}
