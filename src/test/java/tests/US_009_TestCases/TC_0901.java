package tests.US_009_TestCases;

import org.testng.annotations.Test;
import pages.US_009_page;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0901 extends TestBaseRapor {

    //1) Kullanici Concort Hotel sayfasina gider.
    //2) Kullanici sag ustteki login butonuna tiklar
    //3) Kullanici acilan menude username ve password girer
    //4) Kullanici login butonuna basar
    //5) Acilan sayfadan Hotel Management butonuna tiklar
    //6) Asagida acilan Room reservation butonuna tiklar

    @Test
    public void test() {

        US_009_page us_009_page=new US_009_page();
        extentTest=extentReports.createTest("US09-TC01 Hotel Management sekmesinden Room Reservation'a tıklanmalı");

        us_009_page.ConcortHotelLogin();
        extentTest.info("Basarili sekilde giris yapildi");

        us_009_page.hotelManagementLinki.click();
        extentTest.info("Hotel Management Linkine tiklandi");

        us_009_page.roomReservationLinki.click();
        extentTest.info("Room Reservation Linkine tiklandi");

    }

}
