package tests.US_001_TestCases;

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

import javax.swing.*;

public class TC_0104 {
    US_001_page us_001_page= new US_001_page(Driver.getDriver());
    @BeforeTest
    private void test() {
        Driver.getDriver().get(ConfigReader.getProperty("US01ConcortHotel"));

    }
    @Test(priority = 1)
    public void concortHotelSayfasi() {
        //1- kullanici Concort Hotel sayfasina gider
        //expected Result= Url de Concort Hotel yazisi gorunur
       // System.out.println(Driver.getDriver().getCurrentUrl());
        SoftAssert softAssert=new SoftAssert();
softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("US01ConcortHotel"));
    }
     @Test(priority = 2)
    public void recentBlogYazisi(){
//kullanici Concort Hotel sayfasinda recent blog yazisina kadar gitti
//Recent Blog yazisi gorunmeli
    Actions actions=new Actions(Driver.getDriver());
    actions.sendKeys(Keys.END)
            .sendKeys(Keys.PAGE_UP)
            .sendKeys(Keys.PAGE_UP).perform();
    Assert.assertTrue(us_001_page.recentBlogYazisi.isDisplayed());
    }
     @Test(priority = 3)
    public void recentBlogIlkResim(){
      //kullanici Recent Blog bolumundeki ilk bloga tiklar
      //Recent Blog altindaki ilk bolum tiklanmali
         us_001_page.recentBlogYazisiIlkBlog.click();
         SoftAssert softAssert=new SoftAssert();
         softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("US01RecentBlogYazisiIlkBlog"));
    }

    @Test(priority = 4)
    public void instagramSayfasi(){
        //kullanici blog sayfasinda intagram sayfasini gorur
        //Instragram yazisinin aktif olmadigini test etmeli
        Actions actions=new Actions(Driver.getDriver());
actions.sendKeys(Keys.PAGE_DOWN).perform();
      SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(us_001_page.instagramYazisi.isDisplayed());
    actions.moveToElement(us_001_page.instagramYazisi).perform();
    actions.doubleClick(us_001_page.instagramYazisi).perform();
    }
   @Test(priority = 5)
   public void instagramSayfasiIlkFotograf() throws InterruptedException {
        //kullanici instagram bolumundeki ilk fotografa tiklar
       //ilk fotograf tiklanmali
us_001_page.InstagramYazisiIlkFotograf.click();
Actions actions= new Actions(Driver.getDriver());

actions.sendKeys(Keys.ESCAPE).perform();
   }

@AfterClass
    public void TearDown(){
        Driver.closeDriver();
}
}
