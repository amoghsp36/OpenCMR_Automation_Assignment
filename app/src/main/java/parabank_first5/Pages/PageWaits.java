package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageWaits{
    private WebDriver webDriver;
    private WebDriverWait wait;
    public PageWaits(WebDriver webDriver){
        this.webDriver=webDriver;
        this.wait=new WebDriverWait(webDriver, Duration.ofSeconds(2));
    }
    public WebElement waitForElementToBePresent(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
