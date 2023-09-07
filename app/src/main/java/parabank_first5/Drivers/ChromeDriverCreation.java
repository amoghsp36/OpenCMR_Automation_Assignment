package parabank_first5.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreation implements WebDriverCreation{
    @Override
    public WebDriver driverCreation(){
        return new ChromeDriver();
    }

}
