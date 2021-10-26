package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_004_page {
    public US_004_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
