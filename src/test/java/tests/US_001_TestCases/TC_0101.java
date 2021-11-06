package tests.US_001_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_001_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class TC_0101  {
    US_001_page us_001_page= new US_001_page(Driver.getDriver());
@BeforeTest
private void test(){
    Driver.getDriver().get(ConfigReader.getProperty("US01ConcortHotel"));


}
    @Test(priority = 1)
    public void kullaniciSayfasi() {
     //1- kullanici Concort Hotel sayfasina gider
     //expected Result= Rooms butonu gorunur

Assert.assertTrue(us_001_page.roomsButonu.isDisplayed());

    }

    @Test(priority = 2)
    public void about(){
//kullanici About butonuna gelir
//About butonu tiklanmali
    Actions actions=new Actions(Driver.getDriver());

    actions.moveToElement(us_001_page.aboutButonu)
              .click().perform();

        System.out.println("url : "+Driver.getDriver().getCurrentUrl());

    }

@Test(priority = 3)
    public void roomsButonu() throws InterruptedException {
    //rooms butonuna tiklar
    //expected result: rooms butonu gorunmeli

    us_001_page.roomsButonu.click();
    Assert.assertTrue(us_001_page.roomsGorundu.isDisplayed());
}
@Test(priority = 4)
public void concortHotelLogosu() throws InterruptedException {
    Thread.sleep(5000);

    us_001_page.concortHotelButonu.click();
    Assert.assertTrue(us_001_page.HomeTusu.isDisplayed());

}
@AfterClass
    public void TearDown(){
    Driver.closeDriver();
}

}
