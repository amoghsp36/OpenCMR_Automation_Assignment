package parabank_first5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatient extends BasePage{

    By firstName = By.name("givenName");
    By familyName = By.name("familyName");
    By nextButton = By.id("next-button");
    By gender = By.cssSelector("#gender-field > option:nth-child(1)");
    By date = By.id("birthdateDay-field");
    WebElement month = webDriver.findElement(By.id("birthdateMonth-field"));
    By year = By.id("birthdateYear-field");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By phoneNumber = By.name("phoneNumber");
    WebElement relationshipType = webDriver.findElement(By.id("relationship_type"));
    By personRelatedToPatient = By.xpath("//*[@id=\"relationship\"]/p[2]/input[1]");
    By confirmButton = By.id("submit");
    public RegisterPatient(WebDriver webDriver){
        super(webDriver);
    }
    public RegisterPatient formFillOut(){
        pageActions.type(firstName,"qwerty");
        pageActions.type(familyName,"zxcvbnm");
        pageActions.click(nextButton);

        pageActions.click(gender);
        pageActions.click(nextButton);

        pageActions.type(date,"9");
        Select select = new Select(month);
        select.selectByIndex(2);
        pageActions.type(year,"2010");
        pageActions.click(nextButton);

        pageActions.type(address1,"India");
        pageActions.type(address2,"Bangalore");
        pageActions.click(nextButton);

        pageActions.type(phoneNumber,"1234567890");
        pageActions.click(nextButton);

        Select select1 = new Select(relationshipType);
        select1.selectByIndex(3);
        pageActions.type(personRelatedToPatient,"pqrst");
        pageActions.click(nextButton);

        pageActions.click(confirmButton);
        return new RegisterPatient(webDriver);
    }

}