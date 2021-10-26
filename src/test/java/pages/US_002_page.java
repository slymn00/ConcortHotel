package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_002_page {
    public US_002_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
