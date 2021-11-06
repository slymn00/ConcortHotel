package tests.US_009_TestCases;

import org.testng.annotations.Test;
import pages.US_009_page;
import utilities.TestBaseRapor;

public class TC_0903 extends TestBaseRapor {

    //1) Kullanici Concort Hotel sayfasina gider.
    //2) Kullanici sag ustteki login butonuna tiklar
    //3) Kullanici acilan menude username ve password girer
    //4) Kullanici login butonuna basar
    //5) Acilan sayfadan Hotel Management butonuna tiklar
    //6) Asagida acilan Room reservation butonuna tiklar
    //7) Details butonuna tiklar
    //8) Kullanici gosterilen datalari degistirir

    @Test
    public void test() {

        US_009_page us_009_page=new US_009_page();
        extentTest=extentReports.createTest("US09-TC03 Datalar degistirilebilmeli");

        us_009_page.ConcortHotelLogin();
        extentTest.info("Basarili sekilde giris yapildi");

        us_009_page.hotelManagementLinki.click();
        extentTest.info("Hotel Management Linkine tiklandi");

        us_009_page.roomReservationLinki.click();
        extentTest.info("Room Reservations Linkine tiklandi");

        us_009_page.roomReservationDetailsLinki.click();
        extentTest.info("Room Reservations Details Linkine tiklandi");

        us_009_page.roomReservationDetailsContactSurnameKutusu.sendKeys("Yuksel");
        us_009_page.roomReservationDetailsNotesKutusu.sendKeys("Yeni notlar girilebilir");
        extentTest.info("Datalardan ContactName ve Notes degistirildi");

    }
}
