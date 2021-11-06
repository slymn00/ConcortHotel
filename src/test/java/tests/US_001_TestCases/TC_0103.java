package tests.US_001_TestCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_001_page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_0103 {
    US_001_page us_001_page= new US_001_page(Driver.getDriver());

    @Test(priority =1 )
    public void concortHotelSayfasiGit(){
//kullanici Concort Hotel sayfasina gider
//url concort Hotel icermeli
        Driver.getDriver().get(ConfigReader.getProperty("US01ConcortHotel"));
        SoftAssert softAssert= new SoftAssert();
                softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("US01ConcortHotelURL"),"beklenen concorthotel yazisi yok");
    }
@Test(priority =2 )
public void OurRoomsYazisi(){
        //kullanici OurRooms yazisina kadar gelir
        //our Rooms yazisi gorunmeli
    Actions actions= new Actions(Driver.getDriver());
    actions.sendKeys(Keys.PAGE_DOWN)
            .sendKeys(Keys.PAGE_DOWN)
            .sendKeys(Keys.PAGE_DOWN)
            .sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ARROW_DOWN).perform();

    Assert.assertTrue(us_001_page.ourRoomsYazisi.isDisplayed());
    }

@Test(priority = 3)
public void ikinciRoom() throws InterruptedException {
        //kullanici ikinci room'u kontrol etmelidir
       //ikinci room'da fiyat gorunmeli

    Actions actions= new Actions(Driver.getDriver());

    Thread.sleep(2000);
  actions.moveToElement(us_001_page.ikinciRoomsbutonu).perform();

    Thread.sleep(3000);
    us_001_page.fiyatBilgisi.isDisplayed();
    }
    @Test(priority = 4)
    public void viewRoomsDetail(){
        //kullanici view room details butonuna tiklar
        //butona tiklanmali
        us_001_page.ikinciRoomsbutonu.click();

        SoftAssert softAssert=new SoftAssert();
       softAssert.assertTrue (Driver.getDriver().getCurrentUrl().contains("US01ViewRoomsURL"));
    }
@Test(priority = 5)
public void loginYazisiButonuGorunur(){

        Assert.assertTrue(us_001_page.loginYazisiButonu.isDisplayed());
        us_001_page.loginYazisiButonu.click();
Driver.closeDriver();
    }}


