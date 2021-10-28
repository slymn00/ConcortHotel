package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_010_page {
    public US_010_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
