package tests.US_003_TestCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_003_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_003_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0304  extends TestBaseRapor {

    @Test
    public void logIn() throws InterruptedException {

        // 1- kullanici Concort Hotel sayfasina gidebilmeli
        Driver.getDriver().get(ConfigReader.getProperty("US03ConcortHotel"));

        //  //  US_003_page sayfasindan Obje olusturmaliyiz
        US_003_page us_003_page=new US_003_page();

        //2-Kullanici "Concort Hotel" yazisi görülebilmeli
        Assert.assertTrue(us_003_page.concortHotelYazisi.isDisplayed(),"Concort Hotel yazisi gorulmedi");

        //3-Kullanici " log in" yazisi görebilmeli
        Assert.assertTrue(us_003_page.loginYazisiButonu.isDisplayed(),"Log in yazisi gorulmedi");

        //4-Kullanici "log in" butonuna tiklayabilmeli
        us_003_page.loginYazisiButonu.click();

        //5- Create a New account yazisi görünür olmali
        Assert.assertTrue(us_003_page.createaNewAccountButonu.isDisplayed(),"Create a new Account yazisi gorulmedi");

        //6- Kullanici Create a New Account butonu tiklanabilir olmali
        us_003_page.createaNewAccountButonu.click();

        //8-Username Butonuna username girebilmeli
        us_003_page.regUserNameText.sendKeys(ConfigReader.getProperty("regUserName"));

        //9-Kullanici Password girebilmeli
        us_003_page.regPasswordText.sendKeys(ConfigReader.getProperty("regPassword"));

        //10-Kullanici Email girebilmeli
        Faker faker=new Faker();
        us_003_page.regEmailText.sendKeys(faker.internet().emailAddress());

        //11-Kullanici Full Name girebilmeli
        us_003_page.regFullNameText.sendKeys(ConfigReader.getProperty("regFullName"));

        //12-Kullanici Phone No girebilmeli
        us_003_page.regPhoneNoText.sendKeys(ConfigReader.getProperty("regPhoneNo"));

        //13-Kullanici Social Security Number girebilmeli
        us_003_page.regSSNText.sendKeys(ConfigReader.getProperty("regSSN"));


        //14-Kulllanici Driving License girebilmeli
        us_003_page.regDrivingLicenseText.sendKeys(ConfigReader.getProperty("regDrivingLicense"));


        //15-Kullanici  Select Countryiye tiklayabilmeli ve Select Country secebilmeli
        Select select=new Select(us_003_page.regCountryText);
        select.selectByVisibleText(ConfigReader.getProperty("regCountry"));

        //16-Kullanici Select State tiklanabilir olmali ve Select State secebilmeli
        Select select1=new Select(us_003_page.regStateText);
        select1.selectByVisibleText(ConfigReader.getProperty("regState"));

        //17 - Kullanici adres bilgilerini yazmali
        us_003_page.regAddressText.sendKeys(ConfigReader.getProperty("regAddress"));


        //17-Kullanici Working Sector yazabilmeli
        us_003_page.regWorkingSectorText.sendKeys(ConfigReader.getProperty("regWorkingSector"));


        //18-Kullanici Birth Date yazabilmeli
        us_003_page.regBirthDateText.sendKeys(ConfigReader.getProperty("regBirthDate"));

        // 19 - Kullanici Save butonuna tiklamali
        us_003_page.regSaveButton.click();

        //20 - Save Butonuna tikladiktan sonra "User Data was inserted successfully" yazisi gorunmeli
      Assert.assertTrue(us_003_page.regAlertMessage.isDisplayed());
    //Assert.assertEquals(us_003_page.regAlertMessage,"User Data was inserted successfully");




    }}