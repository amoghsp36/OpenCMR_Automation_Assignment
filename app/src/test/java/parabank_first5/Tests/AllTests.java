package parabank_first5.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import parabank_first5.Pages.Login;
import parabank_first5.Pages.PageActions;

public class AllTests {
    @Test
    public void shouldLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        PageActions pageActions = new PageActions(webDriver);
        pageActions.navigateTo("https://demo.openmrs.org/");
        Login login = new Login(webDriver);
        login.patientLogin();
        Thread.sleep(2000);
        webDriver.quit();
    }
    @Test
    public void shouldRegisterPatient(){

    }
}
