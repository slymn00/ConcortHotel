package tests.US_009_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_009_page;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0904 extends TestBaseRapor {

    //1) Kullanici Concort Hotel sayfasina gider.
    //2) Kullanici sag ustteki login butonuna tiklar
    //3) Kullanici acilan menude username ve password girer
    //4) Kullanici login butonuna basar
    //5) Acilan sayfadan Hotel Management butonuna tiklar
    //6) Asagida acilan Room reservation butonuna tiklar
    //7) Details butonuna tiklar
    //8) Kullanici gosterilen datalari degistirir
    //9) Kullanici save butonuna tiklar

    @Test
    public void test() throws InterruptedException {

        US_009_page us_009_page=new US_009_page();
        extentTest=extentReports.createTest("US09-TC04 Save butonu calismali");

        us_009_page.ConcortHotelLogin();
        extentTest.info("Basarili sekilde giris yapildi");

        us_009_page.hotelManagementLinki.click();
        extentTest.info("Hotel Management Linkine tiklandi");

        us_009_page.roomReservationLinki.click();
        extentTest.info("Room Reservations Linkine tiklandi");

        us_009_page.roomReservationDetailsLinki.click();
        extentTest.info("Room Reservations Details Linkine tiklandi");

        String contactSurnameIlkHali=us_009_page.roomReservationDetailsContactSurnameKutusu.getText();
        System.out.println(contactSurnameIlkHali);
        extentTest.info("Surname in ilk hali bir stringe atandi ve yazdirildi");

        us_009_page.roomReservationDetailsContactSurnameKutusu.clear();
        us_009_page.roomReservationDetailsContactSurnameKutusu.sendKeys("Yuksel");
        us_009_page.roomReservationDetailsNotesKutusu.clear();
        us_009_page.roomReservationDetailsNotesKutusu.sendKeys("Yeni notlar girilebilir");
        Thread.sleep(3000);
        extentTest.info("Datalardan ContactName ve Notes degistirildi ve ekranda yeni datalar goruldu");

        us_009_page.roomReservationDetailsDegistirSaveButonu.click();
        extentTest.info("Save butonuna tiklandi");

        Driver.getDriver().navigate().refresh();
        Thread.sleep(3000);
        extentTest.info("Sayfa refresh yapildi ve datalardan ContactName ve Notes in neler olduklari goruldu");

        String contactSurnameSonHali=us_009_page.roomReservationDetailsContactSurnameKutusu.getText();
        System.out.println(contactSurnameSonHali);
        extentTest.info("Surname in son hali bir stringe atandi ve yazdirildi");

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertNotEquals(contactSurnameIlkHali,contactSurnameSonHali,"Surname nin ilk hali ve son hali ayni, TEST FAILED");
        extentTest.info("Surname in ilk hali ile save isleminden sonraki son halinin ayni oldugu goruldu ve yapilan degisikligin sisteme islenmedigi anlasildi, TEST FAILED");

        softAssert.assertAll();

    }
}
