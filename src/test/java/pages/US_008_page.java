package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_008_page {
    public US_008_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement LoginButonu;
    @FindBy(id = "UserName")
    public WebElement userName;
    @FindBy(id = "Password")
    public WebElement Password;
    @FindBy(id = "btnSubmit")
    public WebElement Login;
    @FindBy(linkText = "Hotel Management")
    public WebElement HotelManagement;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[2]/ul/li[3]/a")
    public WebElement RoomReservations;
    @FindBy(className = "hidden-480")
    public WebElement AddRoomReservation;
    @FindBy(id = "IDUser")
    public WebElement IDUser;
    @FindBy(id = "IDHotelRoom")
    public WebElement IDUser2;
    @FindBy(id = "Price")
    public WebElement Price;
    @FindBy(id = "DateStart")
    public WebElement DateStart;
    @FindBy(id = "DateEnd")
    public WebElement DateEnd;
    @FindBy(id = "AdultAmount")
    public WebElement AdultAmount;
    @FindBy(id = "ChildrenAmount")
    public WebElement ChildrenAmount;
    @FindBy(id = "ContactNameSurname")
    public WebElement ContactNameSurname;
    @FindBy(id = "ContactPhone")
    public WebElement ContactPhone;
    @FindBy(id = "ContactEmail")
    public WebElement ContactEmail;
    @FindBy(id = "Notes")
    public WebElement Notes;
    @FindBy(id = "uniform-Approved")
    public WebElement Approved;
    @FindBy(id = "uniform-IsPaid")
    public WebElement IsPaid;
    @FindBy(id = "btnSubmit")
    public WebElement SAVE;
    @FindBy(className = "bootbox-body")
    public WebElement successfully;




}
