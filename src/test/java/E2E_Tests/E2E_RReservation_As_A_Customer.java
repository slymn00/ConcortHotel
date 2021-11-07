package E2E_Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class E2E_RReservation_As_A_Customer extends TestBaseRapor {

    @Test(groups = "e2e")
    public void rReservation_As_A_Customer_Test(){
        extentTest=extentReports.createTest("Musteri olarak reservasyon","Musteri butun bilgileri gidip reservasyonu olusturabilmeli");
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.loginAsACustomer();
        Assert.assertTrue(logIn_page.profileYazisi.isDisplayed());
        extentTest.pass("profile yazisi gorundu, Test PASSED");
        logIn_page.homeButonu.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("us010_chotel_Title_Home_yazisi")));
        extentTest.pass("Title home yazisi iceriyor, Test PASSED");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        ReusableMethods.waitFor(2);
        logIn_page.ikinciOdaDetailsButonu.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("us010_chotel_url_Room_Detail")));
        extentTest.pass("URL roomdetail iceriyor, Test PASSED");
        logIn_page.DateStart.clear();

        actions.sendKeys(logIn_page.DateStart,ConfigReader.getProperty("us010_chotel_date_start"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_date_end"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_Adult_Count"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_Child_Count"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_Name_on_CC"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_CCN"))
                .perform();
        Select CCExpirationYear=new Select(logIn_page.CCExpirationYear);
        CCExpirationYear.selectByVisibleText(ConfigReader.getProperty("us010_chotel_CC_Expiration_Year"));
        Select CCExpirationMonth=new Select(logIn_page.CCExpirationMonth);
        CCExpirationMonth.selectByVisibleText(ConfigReader.getProperty("us010_chotel_CC_Expiration_Month"));
        actions.sendKeys(logIn_page.CVV,ConfigReader.getProperty("us010_chotel_CVV"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("us010_chotel_Message"))
                .perform();
        Assert.assertTrue(logIn_page.bookThisRoomButton.isEnabled());
        extentTest.pass("Book this room Butonu aktif, Test PASSED");
        logIn_page.bookThisRoomButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(logIn_page.basariliKayitHTMLPopUp.isDisplayed());
        extentTest.pass("Herhangi bir error gorunmuyor, Test PASSED");

        Assert.assertTrue(logIn_page.basariliKayitTexti.isDisplayed());
        extentTest.pass("Basarili kayit texti gorundu, Test PASSED");
        logIn_page.hereLinki.click();
        ReusableMethods.waitFor(2);

        Assert.assertEquals(logIn_page.reservationDetailsYazisi.getText(),ConfigReader.getProperty("us010_chotel_Reservasyon_Yazisi"));
        extentTest.pass("Here bolumune tiklandi ve Reservation Details yazisi gorundu, Test PASSED");
    }

}
