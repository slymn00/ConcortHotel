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

public class E2E_CreateHotel extends TestBaseRapor {

    @Test(groups = "e2e")
    public void e2e_addHotel() throws InterruptedException {
        extentTest=extentReports.createTest("E2E Hotel ekleme","Bir hotel eklenebildigini test et ve En sonda tekrardan hotel list sayfasina git 'List Of Hotels' yazisinin goruldugunu test et");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.login();
        extentTest.info("Basarili bir giris yapildi");
        logIn_page.hotelManagement.click();
        logIn_page.hotelList.click();
        logIn_page.addHotel.click();
        extentTest.info("Hotel management ardindan Hotel list son olarak Add hotel'e tikla");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(logIn_page.addHotelCode, ConfigReader.getProperty("chotel_code"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_customer_name"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_customer_adress"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_customer_phone"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_customer_email"))
                .perform();
        Select select=new Select(logIn_page.addHotelIdDdown);
        select.selectByVisibleText(ConfigReader.getProperty("chotel_dropdown_value"));
        extentTest.info("Gerekli bilgiler girildi");
        logIn_page.addHotelSaveButton.click();
        extentTest.info("Save butonuna tiklandi");
        Thread.sleep(1000);
        Assert.assertTrue(logIn_page.addHotelSuccessfullySaveText.isDisplayed());
        extentTest.pass("Basarili kayit yazisi goruldu, Test PASSED");
        logIn_page.addHotelLastOk.click();
        extentTest.info("Ok butonuna tiklandi");
        Thread.sleep(1000);
        logIn_page.hotelList.click();
        extentTest.info("Tekrardan Hotel list butonuna tiklandi");
        Assert.assertTrue(logIn_page.listOfHotelsText.isDisplayed());
        extentTest.pass("List of Hotels yazisi gorundu, Test PASSED");
        Driver.closeDriver();
    }
}
