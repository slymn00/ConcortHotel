package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_008_page {
    public US_008_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
