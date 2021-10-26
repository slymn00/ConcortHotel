package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_001_page {
    public US_001_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
