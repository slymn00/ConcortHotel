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

    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement basariliGirisYazisiElementi;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement basarisizGirisYazisiElementi;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLink;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotelLink;

    @FindBy(id="Code")
    public WebElement addHotelCodeKutusu;

    @FindBy(id="IDGroup")
    public WebElement addHotelDropdown;

    @FindBy(id="btnSubmit")
    public WebElement addHotelSave;

    @FindBy(xpath="//div[@class='bootbox-body']")
    public WebElement addHotelSuccesfullYazisi;

    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement addHotelAllertOk;

    @FindBy (partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsLinki;

    @FindBy (xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addHotelRoomButonu;

    @FindBy (id="IDHotel")
    public WebElement addRoomIdDropDown;

    @FindBy (id="IDGroupRoomType")
    public WebElement addRoomType;

    @FindBy (id="btnSubmit")
    public WebElement addRoomSaveButonu;

    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement addRoomSuccessfulYazisi;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement addRoomAlertOkButonu;

    @FindBy (linkText = "Hotelrooms")
    public WebElement addRoomHotelRoomsLinki;

    @FindBy (xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement addRoomHotelRoomListYazisi;

    @FindBy(xpath = "//thead/tr[1]/th") // burada Web elementlerden olusan bir List imiz var bu yuzden List yaptik
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//tbody//tr[1]") // buradaki tr satirlari ifade eder
    public WebElement birinciSatir;

    @FindBy(xpath = "//tbody//tr//td[4]") // buradaki td sutunlari ifade eder
    public List<WebElement> dorduncuSutunListesi;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> hucrelerListesi;

    @FindBy(xpath = "//a[@href='/admin/RoomReservationAdmin']")
    public WebElement roomReservationLinki;


    public void ConcortHotelLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("US09_ConcortHotelUrl"));
        US_009_page us_009_page=new US_009_page();
        us_009_page.ilkLoginLinki.click();
        us_009_page.userNameKutusu.sendKeys(ConfigReader.getProperty("US09_userName"));
        us_009_page.passwordKutusu.sendKeys(ConfigReader.getProperty("US09_Password"));
        us_009_page.loginButonu.click();
    }



}
