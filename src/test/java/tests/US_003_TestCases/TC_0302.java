package tests.US_003_TestCases;

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

    public class TC_0302  extends TestBaseRapor {

        @Test
        public void logIn() throws InterruptedException {

            // 1- kullanici Concort Hotel sayfasina gidebilmeli
            Driver.getDriver().get(ConfigReader.getProperty("US03ConcortHotel"));

            //  US_003_page sayfasindan Obje olusturmaliyiz
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


        }







    }
