package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageActions{
    private WebDriver webDriver;
    private PageWaits pageWaits;
    public PageActions(WebDriver webDriver){
        this.webDriver=webDriver;
        this.pageWaits = new PageWaits(webDriver);
    }
    public void click(By by){
        //webDriver.findElement(by).click();
        pageWaits.waitForElementToBePresent(by).click();
    }
    public void type(By by,String text){
        pageWaits.waitForElementToBeVisible(by).sendKeys(text);
        //webDriver.findElement(by).sendKeys(text);
    }
    public void navigateTo(String url){
        webDriver.get(url);
    }
}
