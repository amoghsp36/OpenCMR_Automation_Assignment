package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout extends BasePage{
    By logout = By.cssSelector("#navbarSupportedContent > ul > li.nav-item.logout > a");
    public Logout(WebDriver webDriver){
        super(webDriver);
    }
    public void logoutPage(){
        pageActions.click(logout);
    }
}
