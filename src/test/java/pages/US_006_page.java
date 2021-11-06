package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US_006_page {
    public US_006_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement logIn;

    @FindBy (xpath = "//input[@class='form-control required']")
    public WebElement userName;

    @FindBy (xpath = "//input[@class='form-control required password']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='btnSubmit']")
    public WebElement enterButonu;

    @FindBy (xpath = "//span[text()='Hotel Management']")
    public  WebElement hotelManage;

    @FindBy (xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoom;

    @FindBy (xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoom;

    @FindBy (xpath = "//select[@id='IDHotel']")
    public WebElement addRoomIdDropDown;

    @FindBy (xpath = "//select[@id='IDGroupRoomType']")
    public  WebElement roomTypeDropDown;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement clickButonu;

    @FindBy (xpath = "//a[text()='Hotelrooms']")
    public WebElement addRoomHome;

    @FindBy (xpath = "//span[text()='List Of Hotelrooms']")
    public  WebElement addRoomListYazisi;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement kaydedildiYazisi;

    @FindBy(xpath = "//select[@id='lkpHotels']")
    public WebElement selectHotel;

    @FindBy (xpath = "//select[@id='lkpGroupRoomTypes']")
    public WebElement selectRoomType;

    @FindBy (xpath = "//input[@name='Name']")
    public WebElement addRoomName;

    @FindBy (xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement addRoomSearchButton;

    @FindBy (xpath = "(//div[@class='dataTables_info'])[1]")
    public WebElement addRoomFoundYazisi;

    @FindBy (xpath = "//div[@class='caption']")
    public WebElement addRoomCreatYazisi;

    public void LoginMethod(){
        Driver.getDriver().get(ConfigReader.getProperty("us06_chotel_url"));
        logIn.click();
        userName.sendKeys(ConfigReader.getProperty("us06userName"));
        password.sendKeys(ConfigReader.getProperty("us06password"));
        enterButonu.click();
    }


}
