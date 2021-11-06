package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_007_page {
    public US_007_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Log in")
    public WebElement loginBttn;

    @FindBy(id = "UserName")
    public WebElement usernameTextBox;

    @FindBy(id = "Password")
    public WebElement passwordTextBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginPageLoginBttn;

    @FindBy(id = "menuHotels")
    public WebElement hotelManagementMenu;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement HotelRoomsBttn;

    @FindBy(xpath = "(//li[@class='start open'])[2]")
    public WebElement hotelManagementSubMenu;

    @FindBy(xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement listOfHotelRoomsTitleText;

    @FindBy(xpath = "(//a[@class='btn btn-xs default'])[1]")
    public WebElement firstHotelRoomDetailBttn;

    @FindBy(id = "IDHotel")
    public WebElement idHotelDropdownMenu;

    @FindBy(id = "Code")
    public WebElement codeBox;

    @FindBy(id = "Name")
    public WebElement nameBox;

    @FindBy(id = "Location")
    public WebElement locationBox;

    @FindBy(xpath = "//textarea[@title='Zengin Metin Editörü, Description']")
    public WebElement descriptionTextArea;

    @FindBy(id = "Price")
    public WebElement priceBox;

    @FindBy(id = "IDGroupRoomType")
    public WebElement idGroupRoomTypeDropdownMenu;

    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCountBox;

    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCountBox;

    @FindBy(id = "IsAvailable")
    public WebElement isAvailableBox;

    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("US_007_MainPageUrl"));
        loginBttn.click();
        usernameTextBox.sendKeys(ConfigReader.getProperty("us010_chotel_username"));
        passwordTextBox.sendKeys(ConfigReader.getProperty("us010_chotel_password"));
        loginPageLoginBttn.click();
    }


}
