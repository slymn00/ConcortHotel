package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
