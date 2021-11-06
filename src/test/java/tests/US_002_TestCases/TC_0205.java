package tests.US_002_TestCases;


import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_002_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_0205 extends TestBaseRapor {

/*
    1- Yönetici Concort Hotel sayfasina gider.
    2- Yönetici sag ustteki login butonuna tiklar.
    3- Yönetici Login sayfasindaki Login buttonuna tıklayabilmeli.
*/

    @Test
    public void test() {

        ExtentTest extentTest;
        extentTest = extentReports.createTest("TC_0205");

        US_002_page us_002_page = new US_002_page();

        Driver.getDriver().get(ConfigReader.getProperty("CHURL"));
        extentTest.info("Siteye basariyla gidildi.");

        us_002_page.loginMenu.click();
        extentTest.info("Menü'de Login butonuna tiklandi.");

        Assert.assertTrue(us_002_page.loginAccount.isEnabled());
        extentTest.pass("Login sayfasindaki Login butonu tiklanabilir.");
    }
}
