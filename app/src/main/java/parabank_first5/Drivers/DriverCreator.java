package parabank_first5.Drivers;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverCreator {
    public WebDriver create(String browser){
        switch (browser.toLowerCase()){
            case "edge":return new EdgeDriverManager().create();
            //case "edge":WebDriverManager.edgedriver().setup();


            case "firefox":return new FirefoxDriverManager().create();
            //case "firefox":WebDriverManager.firefoxdriver().setup();
            //default:WebDriver webDriver = new ChromeDriver();
            default:WebDriver webDriver=new ChromeDriverManager().create();
                return webDriver;

        }
    }
}
