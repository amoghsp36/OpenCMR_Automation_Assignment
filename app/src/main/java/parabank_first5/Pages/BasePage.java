package parabank_first5.Pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver webDriver;
    protected PageActions pageActions;
    protected PageWaits pageWaits;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.pageActions = new PageActions(webDriver);
        this.pageWaits = new PageWaits(webDriver);
    }
}
