package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OperationsPage extends BasePage{

    By registerLink = By.cssSelector("#referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension");
    public OperationsPage(WebDriver webDriver){
        super(webDriver);
    }
    public RegisterPatient RegistrationDesk(WebDriver webDriver){
        pageActions.click(registerLink);
        return new RegisterPatient(webDriver);
    }

}
