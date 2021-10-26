package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_009_page {
    public US_009_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
