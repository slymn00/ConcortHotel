package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LogIn_Page {
    public LogIn_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
