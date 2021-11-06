package tests.US_002_TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_002_page;
import utilities.TestBaseRapor;

public class TC_0202 extends TestBaseRapor {

/*
    1- Yönetici Concort Hotel sayfasina gider.
    2- Yönetici sag ustteki login butonuna tiklar.
    3- Yönetici isim ve password textbox'larina gecersiz kullanici adi ve sifre girer.
    4- Yönetici login butonuna basar.
    5- Username or password is incorrect yazisini gorur.
*/

    @Test
    public void test() {

        ExtentTest extentTest;
        extentTest = extentReports.createTest("TC_0202");

        US_002_page us_002_page = new US_002_page();

        us_002_page.concortHotelWrongLogin();
        extentTest.info("Giris yapilamadi");

        Assert.assertTrue(us_002_page.wrongLoginTextElement.isDisplayed());
        extentTest.pass("Giris yapilamadigi dogrulandi.");
    }
}
