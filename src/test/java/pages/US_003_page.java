package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_003_page {
    public US_003_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
