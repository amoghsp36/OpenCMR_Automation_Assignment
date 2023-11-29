package parabank_first5.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import parabank_first5.Pages.*;

public class AllTests {
    WebDriver webDriver;
    private Login login;
    private OperationsPage operationsPage;
    private RegisterPatient registerPatient;
    private SearchPatient searchPatient;
    private Privileges privileges;
    private PageActions pageActions;
    private Appointment appointment;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        webDriver = new ChromeDriver(chromeOptions);
//        WebDriver webDriver=new DriverCreator().create(browser);
        login = new Login(webDriver);
        operationsPage = new OperationsPage(webDriver);
        searchPatient = new SearchPatient(webDriver);
        privileges = new Privileges(webDriver);
        appointment = new Appointment(webDriver);
    }
    @BeforeTest
    public void shouldLogin() throws InterruptedException {
        //Arrange
        PageActions pageActions = new PageActions(webDriver);
        pageActions.navigateTo("https://demo.openmrs.org/");
        //Act
        login.patientLogin();
        Thread.sleep(2000);
    }
    @Test(groups = "sanity",priority = 1)
    public void shouldRegisterPatient() throws InterruptedException {
        //Arrange
        operationsPage.RegistrationDesk(webDriver);
        RegisterPatient registerPatient = new RegisterPatient(webDriver);
        //Act
        registerPatient.formFillOut();
        Thread.sleep(2000);
        //Assert
        Assert.assertEquals(registerPatient.patientDetails(),"qwerty");
        registerPatient.patientContactInfo();
        Assert.assertEquals(registerPatient.pnoVerification(),"1234567890");
        PageActions pageActions = new PageActions(webDriver);
        pageActions.navigateToHome();
    }

    @Test(groups = "regression",priority = 2)
    public void shouldSearchForPatient() throws InterruptedException {
        //Arrange
        String visitDate = "07.Sep.2023";
        String pHeight = "141";
        //Act
        operationsPage.patientDetails(webDriver);
        searchPatient.findPatientByIdOrName();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        //Assert
        //Assert.assertEquals(searchPatient.getVisitDetails(),visitDate);
        Assert.assertTrue(searchPatient.getHeightDetails().equals(pHeight));
        PageActions pageActions = new PageActions(webDriver);
        pageActions.navigateToHome();
    }

    @Test(groups = "regression",priority = 3)
    public void shouldManagePrivileges() throws InterruptedException {
        //Arrange
        //Act
        operationsPage.configureData(webDriver);
        privileges.managePrivileges();
        privileges.addPrivileges();
        privileges.searchPrivileges();
        //Assert
        Assert.assertEquals(privileges.assertionSelectors(),"Add Observations","The added privilege name does not match");
        PageActions pageActions = new PageActions(webDriver);
        pageActions.navigateToHome();
    }

    @Test(groups = "regression",priority = 4)
    public void shouldScheduleAppointments() throws InterruptedException {
        //Arrange
        //Act
        operationsPage.AppointmentScheduling();
        appointment.goToServices();
        appointment.addNewServiceType();
        //Assert
        Assert.assertEquals(appointment.getDuration(),"cancer ");
        Assert.assertFalse(appointment.getDuration().equals(appointment.editDuration()));
        PageActions pageActions = new PageActions(webDriver);
        pageActions.navigateToHome();
    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }
}
