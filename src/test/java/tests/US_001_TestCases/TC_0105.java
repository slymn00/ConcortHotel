package tests.US_001_TestCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_001_page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_0105 {

    US_001_page us_001_page= new US_001_page(Driver.getDriver());
    @BeforeTest
    private void test() {
        Driver.getDriver().get(ConfigReader.getProperty("US01ConcortHotel"));

    }
@Test
    public void concortHotelSayfasi(){
    //kullanici concort Hotel sayfasina gider
    //expected:title concort icermeli
    SoftAssert softAssert=new SoftAssert();
    softAssert.assertTrue(us_001_page.concortHotelButonu.getText().contains(ConfigReader.getProperty("US01TitleConcortYazisi")));
    }
@Test
    public void contacButonu(){

        //kullanici contact sekmesine tiklar
    //expected : contact sekmesi tiklanmali
    us_001_page.contacButonu.click();
    SoftAssert softAssert= new SoftAssert();
    softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("US01ContacButonuUrl"));

}
@Test
public void textBoxlar(){
        //kullanici text Boxlari doldurur
    //expected: text boxlar doldurulabilmeli
    us_001_page.textBoxName.click();

    Actions actions= new Actions(Driver.getDriver());
    Faker faker= new Faker();
    actions.sendKeys(faker.name().fullName())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.internet().emailAddress())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.phoneNumber().phoneNumber())
            .sendKeys(Keys.TAB)
            .sendKeys("cift kisilik besikli oda")

            .sendKeys(Keys.TAB)
            .sendKeys("en kisa zamanda cevap donerseniz cok mutlu olurum!")
            .sendKeys(Keys.TAB).perform();
}
@Test
public void sendMessageButonu(){
        //kullanici send Message butonuna tiklar
        //send Message butonu tiklanmali
us_001_page.sendMessageButonu.click();
SoftAssert softAssert=new SoftAssert();
softAssert.assertTrue(us_001_page.sendMessageButonuHataYazisi.isDisplayed());

}








@AfterClass
    public void tearDown(){
        Driver.closeDriver();
}




}
