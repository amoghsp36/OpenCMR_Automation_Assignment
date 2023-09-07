package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Privileges extends BasePage{

    By metaData = By.cssSelector("#org-openmrs-module-adminui-Privileges-org-openmrs-module-adminui-Privileges-extension");
    By addNewPrivilege = By.cssSelector("input[value='Add New Privilege']");
    By privilegeName = By.id("privilege-field");
    By privilegeDescription = By.id("description-field");
    By savePrivilege = By.id("save-button");
    public Privileges(WebDriver webDriver){
        super(webDriver);
    }
    public Privileges managePrivileges(){
        pageActions.click(metaData);
        return new Privileges(webDriver);
    }
    public Privileges addPrivileges(){
        pageActions.click(addNewPrivilege);
        pageActions.type(privilegeName,"Add Diseases");
        pageActions.type(privilegeDescription,"Added new Disease types");
        return new Privileges(webDriver);
    }
}
