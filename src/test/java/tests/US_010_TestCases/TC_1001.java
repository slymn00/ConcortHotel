package tests.US_010_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_010_page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_1001 {
    /*
    Kullanici login edebilme
    1-Kullanici Concort Hotel sayfasina gider
    2-Kullanici sag ustteki login butonuna tiklar
    3-Kullanici acilan menude username textboxa tiklar ve username datasini yazar
    4-Kullanici acilan menude password textboxa tiklar ve password datasini yazar
    5-Kullanici login butonuna basar
    6- Login islemi gerceklestirilmis olur.
     */

    @Test
    public void kullanici_login_test(){

        Driver.getDriver().get(ConfigReader.getProperty("us010_chotel_url"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("us010_chotel_Title_Home_yazisi")));
    }
}
