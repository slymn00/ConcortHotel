package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US_005_page {
    public US_005_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (linkText = "Log in")
    public WebElement loginMenu;

    @FindBy (xpath = "//input[@id='UserName']")
    public WebElement username;

    @FindBy (xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy (id = "btnSubmit")
    public WebElement loginAccount;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement wrongLoginTextElement;

    @FindBy (xpath="//span[text()='ListOfUsers']")
    public WebElement succesLoginTextElement;

    @FindBy (xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagement;
    @FindBy(xpath = "//a[@href='/admin/RoomReservationAdmin']")
    public WebElement roomReservationLink;
    @FindBy (xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelList;

    @FindBy (xpath = "//i[@class='fa fa-plus']")
    public WebElement addHotel;

    @FindBy (partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;

    @FindBy (xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoom;

    @FindBy (id = "IDHotel")
    public WebElement idHotelDropDown;

    @FindBy (id = "Code")
    public WebElement addHotelCodeBox;

    @FindBy (id="IDGroup")
    public WebElement addHotelDropDown;

    @FindBy (id = "IDGroupRoomType")
    public WebElement selectRoomTypeDropDown;

    @FindBy (id = "btnSubmit")
    public WebElement addRoomSave;

    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement addRoomSucces;

    @FindBy (xpath = "//button[@data-bb-handler='ok']")
    public WebElement addRoomSuccesAlertOk;

    @FindBy (linkText = "Hotelrooms")
    public WebElement addHotelRoomsHome;

    @FindBy (xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement listOfHotelRoomsText;

    @FindBy (id="btnSubmit")
    public WebElement addHotelSave;

    @FindBy (xpath="//div[@class='bootbox-body']")
    public WebElement addHotelSuccesText;

    @FindBy (xpath="//button[@class='btn btn-primary']")
    public WebElement addHotelAlertOk;

    @FindBy (xpath = "//thead/tr[1]/th")
    public List <WebElement> basliklarListesi;

    @FindBy (xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy (xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy (xpath = "//tbody//tr[1]")
    public WebElement birinciSatir;

    @FindBy (xpath = "//tbody//tr//td[4]")
    public List <WebElement> dördüncüSutunListesi;

    public void ConcortHotelLogin(){
        US_005_page us_005_page=new US_005_page();
        us_005_page.loginMenu.click();
        us_005_page.username.sendKeys(ConfigReader.getProperty("US05_userName"));
        us_005_page.password.sendKeys(ConfigReader.getProperty("US05_Password"));
        us_005_page.loginAccount.click();
    }
    public void ConcortGecersizHotelLogin(){
        US_005_page us_005_page=new US_005_page();
        us_005_page.loginMenu.click();
        us_005_page.username.sendKeys(ConfigReader.getProperty("US05_gecersizUserName"));
        us_005_page.password.sendKeys(ConfigReader.getProperty("US05_gecersizPassword"));
        us_005_page.loginAccount.click();
    }

}
