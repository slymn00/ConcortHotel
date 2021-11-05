package tests.US_008_TestCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_008_page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Date;

public class TC_0801 {
    @Test
    public void room_reservations() throws InterruptedException {
        US_008_page us_008_page=new US_008_page();

        Driver.getDriver().get(ConfigReader.getProperty("US_08_ConcortHotelUrl"));
        us_008_page.LoginButonu.click();

        us_008_page.userName.sendKeys(ConfigReader.getProperty("us_08_userName"));
        us_008_page.Password.sendKeys(ConfigReader.getProperty("us_08_Password"));
        us_008_page.Login.click();
        us_008_page.HotelManagement.click();
        us_008_page.RoomReservations.click();
        us_008_page.AddRoomReservation.click();
        Thread.sleep(1000);
        Select select=new Select(us_008_page.IDUser);
        select.selectByVisibleText("manager");
        Select select2=new Select(us_008_page.IDUser2);
        select2.selectByVisibleText("Guzelbahce");
        us_008_page.IDUser2.sendKeys(Keys.TAB);
        Faker faker=new Faker();
        us_008_page.Price.sendKeys(faker.commerce().price());
        us_008_page.Price.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        us_008_page.DateStart.sendKeys("01-01-2022");
        us_008_page.DateStart.sendKeys(Keys.TAB);
        us_008_page.DateEnd.sendKeys("12-01-2022");
        us_008_page.DateEnd.sendKeys(Keys.TAB);
        us_008_page.AdultAmount.sendKeys(faker.number().digit());
        us_008_page.AdultAmount.sendKeys(Keys.TAB);
        us_008_page.ChildrenAmount.sendKeys(faker.number().digit());
        us_008_page.ChildrenAmount.sendKeys(Keys.TAB);
        us_008_page.ContactNameSurname.sendKeys(faker.name().fullName());
        us_008_page.ContactNameSurname.sendKeys(Keys.TAB);
        us_008_page.ContactPhone.sendKeys(faker.phoneNumber().phoneNumber());
        us_008_page.ContactPhone.sendKeys(Keys.TAB);
        us_008_page.ContactEmail.sendKeys(faker.internet().emailAddress());
        us_008_page.ContactEmail.sendKeys(Keys.TAB);
        us_008_page.Notes.sendKeys("Hotelinizde ilk defa konakladik ve arkadaslar olarak gercekten cok memnun kaldik.");
        us_008_page.Notes.sendKeys(Keys.TAB);
        us_008_page.Approved.click();
        //us_008_page.Approved.sendKeys(Keys.TAB);
        us_008_page.IsPaid.click();
        //us_008_page.IsPaid.sendKeys(Keys.TAB);
        us_008_page.SAVE.click();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(us_008_page.successfully.isDisplayed(),"beklenen RoomReservation was inserted successfully yazisi cikmadi");

    }

    @AfterClass
    public void teardown(){
        Driver.closeDriver();
    }
}
