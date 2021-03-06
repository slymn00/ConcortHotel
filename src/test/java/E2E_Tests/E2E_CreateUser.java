package E2E_Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class E2E_CreateUser extends TestBaseRapor {

    @Test(groups = "e2e")
    public void e2e_adduserTest() throws InterruptedException {
        extentTest=extentReports.createTest("User Testi","Kullanici sorunsuz bir sekilde user ekleyebilmeli");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.login();
        extentTest.info("Giris yapildi");
        logIn_page.addUserButton.click();
        extentTest.info("User button'a tiklandi");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(logIn_page.addUserUsernameBox, ConfigReader.getProperty("chotel_username"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_password"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_adduser_email"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_adduser_fullname"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_adduser_phone"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_adduser_SSN"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_driving_license")).perform();
        Select select=new Select(logIn_page.addUserCountryDdown);
        select.selectByVisibleText(ConfigReader.getProperty("chotel_adduser_Country"));
        Thread.sleep(1000);
        actions.click(logIn_page.asagiinmekicinClick).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.END).perform();



        actions.sendKeys(logIn_page.addUserAddress,ConfigReader.getProperty("chotel_adduser_Address"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_adduser_birtday")).perform();
        actions.sendKeys(logIn_page.workingSector,ConfigReader.getProperty("chotel_adduser_working_sector")).perform();
        Select select1=new Select(logIn_page.addUserRoleDdown);
        select1.selectByVisibleText(ConfigReader.getProperty("chotel_adduser_Role"));
        logIn_page.addUserYes.click();
        extentTest.info("Gerekli textboxlar dolduruldu");
        logIn_page.addUserSaveButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(logIn_page.addUserSuccessfullySaveText.isDisplayed());
        extentTest.pass("Basarili bir sekilde user olusturuldu");
        logIn_page.addUserLastOk.click();
        Driver.closeDriver();




    }
}
