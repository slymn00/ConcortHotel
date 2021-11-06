package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_002_page {

    public US_002_page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
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


    public void concortHotelLogin() {

        Driver.getDriver().get(ConfigReader.getProperty("CHURL"));

        US_002_page us_002_page = new US_002_page();
        us_002_page.loginMenu.click();
        us_002_page.username.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        us_002_page.password.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        us_002_page.loginAccount.click();
    }

    public void concortHotelWrongLogin() {

        Driver.getDriver().get(ConfigReader.getProperty("CHURL"));

        US_002_page us_002_page = new US_002_page();
        us_002_page.loginMenu.click();
        us_002_page.username.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        us_002_page.password.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        us_002_page.loginAccount.click();

    }

    public void concortHotelWrongPasswordLogin() {

        Driver.getDriver().get(ConfigReader.getProperty("CHURL"));

        US_002_page us_002_page = new US_002_page();
        us_002_page.loginMenu.click();
        us_002_page.username.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        us_002_page.password.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        us_002_page.loginAccount.click();

    }

    public void concortHotelWrongUsernameLogin() {

        Driver.getDriver().get(ConfigReader.getProperty("CHURL"));

        US_002_page us_002_page = new US_002_page();
        us_002_page.loginMenu.click();
        us_002_page.username.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        us_002_page.password.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        us_002_page.loginAccount.click();

    }
}
