package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPatient extends BasePage{

    By search = By.id("patient-search");
    By result = By.cssSelector("#patient-search-results-table > tbody > tr");
    //for assertion
    public SearchPatient(WebDriver webDriver){
        super(webDriver);
    }
    public SearchPatient findPatientByIdOrName(){
        pageActions.type(search,"Lisa Green");
        pageActions.click(result);
        return new SearchPatient(webDriver);
    }
    public String getVisitDetails(){
        WebElement recentVisit = webDriver.findElement(By.cssSelector("#coreapps-fr776 > div.info-body > visitbyencountertype > ul > li:nth-child(1) > a"));
        return recentVisit.getText();
    }
    public String getTempDetails(){
        WebElement patientTemp = webDriver.findElement(By.cssSelector("#temperature > span.value"));
        return patientTemp.getText();
    }
}
