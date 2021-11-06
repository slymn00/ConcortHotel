package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US_009_page {
    public US_009_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")
    public WebElement userNameKutusu;

    @FindBy(id = "Password")
    public WebElement passwordKutusu;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;

    @FindBy(xpath = "//a[@href='/admin/RoomReservationAdmin']")
    public WebElement roomReservationLinki;

    @FindBy(xpath = "(//a[@class='btn btn-xs default'])[1]")
    public WebElement roomReservationDetailsLinki;

    @FindBy(id = "ContactNameSurname")
    public WebElement roomReservationDetailsContactSurnameKutusu;

    @FindBy(id = "Notes")
    public WebElement roomReservationDetailsNotesKutusu;

    @FindBy(xpath = "//button[@class='btn green']")
    public WebElement roomReservationDetailsDegistirSaveButonu;

    @FindBy(id = "btnDelete")
    public WebElement roomReservationDetailsDegistirDeleteButonu;


    public void ConcortHotelLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("US09_ConcortHotelUrl"));
        US_009_page us_009_page=new US_009_page();
        us_009_page.ilkLoginLinki.click();
        us_009_page.userNameKutusu.sendKeys(ConfigReader.getProperty("US09_userName"));
        us_009_page.passwordKutusu.sendKeys(ConfigReader.getProperty("US09_Password"));
        us_009_page.loginButonu.click();
    }



}
