package E2E_Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class E2E_CreateRoomReservation {
    @Test(groups = "e2e")
    public void addRoomReservation() throws InterruptedException {
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.login();
        logIn_page.hotelManagement.click();
        logIn_page.roomReservation.click();
        logIn_page.addRoomReservation.click();
        Select select=new Select(logIn_page.addRoomReservationSelectUserDdown);
        select.selectByVisibleText(ConfigReader.getProperty("chotel_roomreservation_user"));
        Select select1=new Select(logIn_page.addRoomReservationSelectHotelroomDdown);
        select1.selectByVisibleText(ConfigReader.getProperty("chotel_roomreservation_hotelroom"));
        Actions actions =new Actions(Driver.getDriver());
        actions.sendKeys(logIn_page.addRoomReservationPrice, ConfigReader.getProperty("chotel_roomreservation_price"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_roomreservation_DateStart")+Keys.TAB)
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_roomreservation_DateEnd")+Keys.TAB)
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_roomreservation_adultAmount"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_roomreservation_childAmount"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_roomreservation_NameSurname"))
                .click(logIn_page.roomReservationContactnameText).perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(logIn_page.roomReservationPhone,ConfigReader.getProperty("chotel_roomreservation_ContactPhone"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_roomreservation_email"))
                .sendKeys(Keys.TAB+ConfigReader.getProperty("chotel_roomreservation_notes")).perform();
        actions.click(logIn_page.roomReservationApprovedButton)
                .click(logIn_page.addRoomReservationSaveButton).perform();
        Thread.sleep(2000);
        Assert.assertTrue(logIn_page.addRoomReservationSuccessfullySaveText.isDisplayed());
        logIn_page.addRoomReservationLastOk.click();
        Driver.closeDriver();

    }
}
