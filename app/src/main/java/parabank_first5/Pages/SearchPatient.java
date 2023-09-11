package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPatient extends BasePage{

    By search = By.id("patient-search");
    By result = By.cssSelector("#patient-search-results-table > tbody > tr:nth-child(1) > td:nth-child(2)");
    String targetText = "Lisa López"; //text to click

    String xpathExpression = "//td[text()='" + targetText + "']";

    By tdElement = By.xpath(xpathExpression);

    //for assertion
    public SearchPatient(WebDriver webDriver){
        super(webDriver);
    }
    public SearchPatient findPatientByIdOrName(){
        pageActions.type(search,"Lisa");
        pageActions.click(tdElement);
        return new SearchPatient(webDriver);
    }
    public String getVisitDetails(){
        WebElement recentVisit = webDriver.findElement(By.cssSelector("#coreapps-fr8201 > div.info-body > visitbyencountertype > ul > li:nth-child(1) > a"));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(recentVisit));
        return recentVisit.getText();
    }
    public String getHeightDetails(){
        WebElement patientHeight = webDriver.findElement(By.cssSelector("#height > span.value"));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(patientHeight));
        return patientHeight.getText();
    }
}
