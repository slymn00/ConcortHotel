package tests.US_002_TestCases;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_002_page;
import utilities.TestBaseRapor;

public class TC_0201 extends TestBaseRapor {

/*
    1- Yonetici Concort Hotel sayfasina gider.
    2- Yonetici sag üstteki login butonuna tiklar.
    3- Yönetici isim ve password textbox'larina dogru kullanici adi ve sifre girer.
    4- Yönetici login butonuna basar.
    5- Title'in Admin yazisi icerdigini gorur.
*/
    @Test
    public void test() {

        ExtentTest extentTest;
        extentTest = extentReports.createTest("TC_0201");

        US_002_page us_002_page = new US_002_page();

        us_002_page.concortHotelLogin();
        extentTest.info("Giris yapildi.");

        Assert.assertTrue(us_002_page.succesLoginTextElement.isDisplayed());
        extentTest.pass("Basariyla giris yapildigi dogrulandi.");
    }
}
