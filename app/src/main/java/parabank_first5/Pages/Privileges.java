package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Privileges extends BasePage{

    By metaData = By.cssSelector("#org-openmrs-module-adminui-Privileges-org-openmrs-module-adminui-Privileges-extension");
    By addNewPrivilege = By.cssSelector("input[value='Add New Privilege']");
    //WebElement privilegeName = webDriver.findElement(By.id("privilege-field"));
    By privilegeName = By.id("privilege-field");
    By privilegeDescription = By.id("description-field");
    By savePrivilege = By.id("save-button");
    By search = By.cssSelector("#list-privileges_filter > label > input[type=\"text\"]");
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
        pageActions.click(savePrivilege);
        return new Privileges(webDriver);
    }

    public Privileges searchPrivileges(){
        pageActions.type(search,"Add Patient");
        return new Privileges(webDriver);
    }
    public String assertionSelectors(){
        String assertText = "Add Observations";
        WebElement prevName = webDriver.findElement(By.xpath("//td[contains(text(),'Add Observations')]"));
        //WebElement privilegeName = webDriver.findElement(By.cssSelector("#list-privileges > tbody > tr:nth-child(4) > td:nth-child(1)"));
        return prevName.getText();
    }
}
