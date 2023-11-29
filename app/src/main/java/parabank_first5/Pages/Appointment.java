package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Appointment extends BasePage{
    By serviceTypes = By.cssSelector("#appointmentschedulingui-manageAppointmentTypes-app");
    By newService = By.cssSelector("#content > div > div:nth-child(1) > button");
    By serviceName = By.name("name");
    By serviceDuration = By.id("duration-field");
    By serviceDescription = By.id("description-field");
    By save = By.id("save-button");
    By title = By.id("manageAppointmentsTypeTitle");
    public Appointment(WebDriver webDriver){
        super(webDriver);
    }
    public Appointment goToServices(){
        pageActions.click(serviceTypes);
        return new Appointment(webDriver);
    }
    public Appointment addNewServiceType() throws InterruptedException {
        pageActions.click(newService);
        pageActions.type(serviceName,"cancer ");
        pageActions.type(serviceDuration,"45");
        pageActions.type(serviceDescription,"curing cancer in just 45 min");
        pageActions.click(save);
        pageWaits.waitForElementToBeVisible(title);
        return new Appointment(webDriver);
    }
    public String getDuration(){
        WebElement time = webDriver.findElement(By.xpath("//td[contains(text(),'nullcancer')]"));
        pageWaits.waitForElementToBeVisibleWithClear(time);
        return time.getText();
    }
    public String editDuration() throws InterruptedException {
        WebElement edit = webDriver.findElement(By.id("appointmentschedulingui-edit-Dermatology"));
        edit.click();
        WebElement serviceDuration = webDriver.findElement(By.cssSelector("#duration-field"));
        pageWaits.waitForElementToBeVisibleWithClear(serviceDuration);
        Thread.sleep(3000);
        return serviceDuration.getText();
    }


}
//#appointmentTypesTable > tbody > tr:nth-child(7) > td:nth-child(2) duration-field div