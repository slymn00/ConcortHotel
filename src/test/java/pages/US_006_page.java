package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_006_page {
    public US_006_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
