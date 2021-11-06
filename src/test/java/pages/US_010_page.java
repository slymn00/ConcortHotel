package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_010_page {
    public US_010_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='navLogon']")
    public WebElement homeLogin;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement loginButonu;

    @FindBy(tagName = "h1")
    public WebElement profileYazisi;

    @FindBy(xpath = "//li[@id='navHome']")
    public WebElement homeButonu;

    @FindBy(xpath = "(//a[text()='View Room Details '])[2]")
    public WebElement ikinciOdaDetailsButonu;

    @FindBy(xpath = "//input[@id='checkin_date']")
    public WebElement DateStart;

    @FindBy(xpath = "//select[@id='CreditCardExpirationYear']")
    public WebElement CCExpirationYear;

    @FindBy(xpath = "//select[@id='CreditCardExpirationMonth']")
    public WebElement CCExpirationMonth;

    @FindBy(xpath = "//input[@id='CVV']")
    public WebElement CVV;

    @FindBy(xpath = "//input[@value='Book this room']")
    public WebElement bookThisRoomButton;


    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement basariliKayitTexti;

    @FindBy(xpath = "(//a[text()=' here '])[2]")
    public WebElement hereLinki;

    @FindBy(xpath = "//h1[text()='Reservation Details']")
    public WebElement reservationDetailsYazisi;

    @FindBy(xpath = "//div[@class='modal-content']")
    public WebElement basariliKayitHTMLPopUp;



    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("us010_chotel_url"));
        homeLogin.click();
        usernameTextBox.sendKeys(ConfigReader.getProperty("us010_chotel_username"));
        passwordTextBox.sendKeys(ConfigReader.getProperty("us010_chotel_password"));
        loginButonu.click();
    }

}
