package parabank_first5.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import parabank_first5.Drivers.ChromeDriverCreation;
import parabank_first5.Pages.*;

public class AllTests {
    WebDriver webDriver;
    private Login login;
    private OperationsPage operationsPage;
    private RegisterPatient registerPatient;
    private SearchPatient searchPatient;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        operationsPage = new OperationsPage(webDriver);
        searchPatient = new SearchPatient(webDriver);
    }
    @Test
    public void shouldLogin() throws InterruptedException {
        PageActions pageActions = new PageActions(webDriver);
        pageActions.navigateTo("https://demo.openmrs.org/");
        login.patientLogin();
        Thread.sleep(2000);
    }
    @Test
    public void shouldRegisterPatient() throws InterruptedException {
        shouldLogin();
        operationsPage.RegistrationDesk(webDriver);
        RegisterPatient registerPatient = new RegisterPatient(webDriver);
        registerPatient.formFillOut();
    }

    @Test
    public void shouldSearchForPatient() throws InterruptedException {
        shouldLogin();
        String visitDate = "07.Sep.2023";
        operationsPage.patientDetails(webDriver);
        searchPatient.findPatientByIdOrName();
        //Assert.assertEquals(searchPatient.getDetails());
    }

    @Test
    public void shouldManagePrivileges() throws InterruptedException {
        shouldLogin();
        operationsPage.configureData(webDriver);


    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }
}
