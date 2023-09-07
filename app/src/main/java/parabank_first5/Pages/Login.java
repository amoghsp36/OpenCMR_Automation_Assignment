package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage{

    By loginUsername = By.id("username");
    By loginPassword = By.id("password");
    By registrationDesk = By.id("Registration Desk");
    By login = By.id("loginButton");
    public Login(WebDriver webDriver){
        super(webDriver);
    }
    public OperationsPage patientLogin(){
        pageActions.type(loginUsername, "admin");
        pageActions.type(loginPassword, "Admin123");
        pageActions.click(registrationDesk);
        pageActions.click(login);
        return new OperationsPage(webDriver);
    }
}
