package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_003_page {

    WebDriver driver;

    public US_003_page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void ConcortHotelLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        US_003_page us_003_page=new US_003_page();
}
    // 1.) Anasayfa Login butonu
    @FindBy(linkText = "Log in")
    public WebElement firstlogIn;

    // 2.) Login icin UserName kutusu
    @FindBy(id = "UserName")
    public WebElement userName;

    // 3.) Login icin Password kutusu
    @FindBy(id = "Password")
    public WebElement password;

    // 4.) Login icin submit butonu
    @FindBy(id = "btnSubmit")
    public WebElement logInButton;

    // 5.) ConcortHotelyazisi gorulebilmeli
    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement concortHotelYazisi;

    // 6.) Log in yazisi gorulebilmeli
    @FindBy(linkText = "Log in")
    public WebElement loginYazisiButonu;

    // 7. ) Create a new account
    @FindBy(xpath = "//span[text()='Create a new account']")
    public WebElement createaNewAccountButonu;

    @FindBy(id = "UserName")
    public WebElement regUserNameText;

    @FindBy(id = "Password")
    public WebElement regPasswordText;

    @FindBy(id = "Email")
    public WebElement regEmailText;

    @FindBy(id = "NameSurname")
    public WebElement regFullNameText;

    @FindBy (id = "PhoneNo")
    public WebElement regPhoneNoText;

    @FindBy(id = "SSN")
    public WebElement regSSNText;

    @FindBy(id = "DrivingLicense")
    public WebElement regDrivingLicenseText;

    @FindBy(id = "IDCountry")
    public WebElement regCountryText;

    @FindBy(id="IDState")
    public WebElement regStateText;

    @FindBy(id = "Address")
    public WebElement regAddressText;

    @FindBy(id = "WorkingSector")
    public WebElement regWorkingSectorText;

    @FindBy(id = "BirthDate")
    public WebElement regBirthDateText;

    @FindBy(id = "btnSubmit")
    public WebElement regSaveButton;

    @FindBy(xpath = "(//div[text()='User Data was inserted successfully'])[2]")
    // @FindBy(xpath = "//div[text()='this email address is already taken']")
    public WebElement regAlertMessage;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement regOkButton;

    @FindBy(xpath = " //div[@id='divMessage']")
    public WebElement linkBelow;

    @FindBy (xpath = "//li[contains( @id, 'Log')]")
    public WebElement loginLink;



    public String printData(int satir, int sutun) {
        // ornekteki haliyle 3.satir, 5.sutundaki elemani yazdiralim
        //  String xpath= //tbody//tr[3]//td[5]
        // degismeyecek kisimlari String, degisecek kisimlari ise parametre ismi olarak yazdik
        String xpath= "//tbody//tr[" + satir +"]//td["+ sutun + "]";
        //System.out.println(xpath);

        // satir no : 3, sutun no : 5
        //System.out.println("satir no : "+ satir+ " sutun no : " + sutun);

        // @FindBy notasyonu parametreli calismadigi icin onceki yontemle locate edelim
        String istenenData = Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("satir no  "+ satir+ ", sutun no : " + sutun + "'deki data : " + istenenData );

        return istenenData;
    }

}