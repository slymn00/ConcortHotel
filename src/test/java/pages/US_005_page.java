package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_005_page {
    public US_005_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
