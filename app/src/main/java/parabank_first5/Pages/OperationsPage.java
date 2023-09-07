package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OperationsPage extends BasePage{

    By registerLink = By.cssSelector("#referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension");
    By findPatient = By.cssSelector("#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension");
    By configureMetaData = By.cssSelector("#org-openmrs-module-adminui-configuremetadata-homepageLink-org-openmrs-module-adminui-configuremetadata-homepageLink-extension");
    public OperationsPage(WebDriver webDriver){
        super(webDriver);
    }
    public RegisterPatient RegistrationDesk(WebDriver webDriver){
        pageActions.click(registerLink);
        return new RegisterPatient(webDriver);
    }
    public SearchPatient patientDetails(WebDriver webDriver){
        pageActions.click(findPatient);
        return new SearchPatient(webDriver);
    }
    public Privileges configureData(WebDriver webDriver){
        pageActions.click(configureMetaData);
        return new Privileges(webDriver);
    }

}
