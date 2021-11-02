package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_001_page {
    WebDriver driver;

    public US_001_page(WebDriver driver)
    {this.driver=driver;
        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy(xpath = "//a[text()='Rooms']")
    public WebElement roomsButonu;

@FindBy(xpath = "//a[text()='About']")
    public WebElement aboutButonu;

@FindBy(xpath = "//h1[@class='mb-4 bread']")
    public WebElement roomsGorundu;


@FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement concortHotelButonu;

@FindBy(linkText ="Home")
    public WebElement HomeTusu;

@FindBy(xpath = "//div[@class='col-md-7 heading-section text-center ftco-animate fadeInUp ftco-animated']")
    public WebElement ourRoomsYazisi;

@FindBy(xpath = "//input[@class='btn btn-primary py-3 px-4 align-self-stretch']")
public WebElement checkAvability;

@FindBy(xpath = "//option[@value='319']")
public WebElement kingSecenegiGorulur;

@FindBy(xpath = "//a[@class='btn-custom'][1]")
public WebElement kingRoomsButonu;

@FindBy(xpath = "//h2[@class='mb-4']")
public WebElement kingRoomsYazisiGorundu;
}
