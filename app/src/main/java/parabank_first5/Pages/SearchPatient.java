package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPatient extends BasePage{

    By search = By.id("patient-search");
    By result = By.cssSelector("#patient-search-results-table > tbody > tr");
    //for assertion
    By recentVisit = By.cssSelector("#coreapps-fr776 > div.info-body > visitbyencountertype > ul > li:nth-child(1) > a");
    By patientTemp = By.cssSelector("#temperature > span.value");
    public SearchPatient(WebDriver webDriver){
        super(webDriver);
    }
    public SearchPatient findPatientByIdOrName(){
        pageActions.type(search,"Lisa Green");
        pageActions.click(result);
        return new SearchPatient(webDriver);
    }
//    public void getDetails(){
//        recentVisit.toString();
//    }
}
