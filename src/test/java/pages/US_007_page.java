package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_007_page {
    public US_007_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
