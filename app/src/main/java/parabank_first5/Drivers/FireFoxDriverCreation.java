package parabank_first5.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverCreation implements WebDriverCreation{
    @Override
    public WebDriver driverCreation(){
        return new FirefoxDriver();
    }
}
