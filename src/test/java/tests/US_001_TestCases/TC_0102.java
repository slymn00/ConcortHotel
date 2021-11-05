package tests.US_001_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.US_001_page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_0102 {
    US_001_page us_001_page= new US_001_page(Driver.getDriver());
    @Test(priority = 1)
    public void concortHotelSayfasi(){
        //kullanici concort Hotel sayfasina gider
        //expexted:title da home tusu gorunmeli
        Driver.getDriver().get(ConfigReader.getProperty("US01ConcortHotel"));
        Assert.assertTrue(us_001_page.HomeTusu.isDisplayed());
    }
@Test(priority = 2)
    public void ourRooms(){
        //kullanici ourRooms yazisina kadar sayfayi asagi indirir
    //Expected:OurRooms yazisi gorunmeli
    Actions actions= new Actions(Driver.getDriver());
    actions.sendKeys(Keys.PAGE_DOWN)
            .sendKeys(Keys.PAGE_DOWN)
            .sendKeys(Keys.PAGE_DOWN).perform();
    Assert.assertTrue(us_001_page.ourRoomsYazisi.isDisplayed());
    }
@Test(priority = 3)
    public void checkAvaibilityButonu() throws InterruptedException {
        //Check Availibity butonun aktif oldugunu kontrol eder
       //Check Availibity butonun aktif olmali

    us_001_page.checkAvability.click();
    Assert.assertTrue(us_001_page.roomsGorundu.isDisplayed());
    Driver.getDriver().navigate().back();

}

@Test(priority = 4)
    public void roomDropDown(){
        //kullanici Room dropDown'undan King secenegini secer
        //expected: King secenegi secmeli


    WebElement selectElement= Driver.getDriver().findElement(By.id("IDRoomType"));
    Select option= new Select(selectElement);
option.selectByIndex(6);
    System.out.println("secilen buton : "+us_001_page.kingSecenegiGorulur.getText());
    }

@Test(priority = 5)
    public void CheckAvabilityButonu(){
//kullanici Check Availibity butonuna tiklar
//Check Avaibility butonu tiklamali

    us_001_page.checkAvability.click();
    System.out.println(Driver.getDriver().getCurrentUrl());

}
@Test(priority = 6)
    public void kingRoomsButonu() throws InterruptedException {

        //kullanici acilan sayfadaki King Room butonuna tiklar
        // King Room butonu tiklanmali
Actions actions= new Actions(Driver.getDriver());
actions.sendKeys(Keys.PAGE_DOWN).perform();
Thread.sleep(6000);
    us_001_page.kingRoomsButonu.click();


}
@Test(priority = 7)
    public void KingRoomYazisi(){
       //Kullanici King Room yazisini gormeli
    //expected:Kullanici King Room yazisini gormeli
us_001_page.kingRoomsYazisiGorundu.isDisplayed();
}
@AfterClass
    public void TearDown(){
        Driver.closeDriver();

}
}
