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
    private Privileges privileges;
    private Appointment appointment;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        operationsPage = new OperationsPage(webDriver);
        searchPatient = new SearchPatient(webDriver);
        privileges = new Privileges(webDriver);
        //appointment = new Appointment(webDriver);
    }
    @Test
    public void shouldLogin() throws InterruptedException {
        //Arrange
        PageActions pageActions = new PageActions(webDriver);
        pageActions.navigateTo("https://demo.openmrs.org/");
        //Act
        login.patientLogin();
        Thread.sleep(2000);
    }
    @Test
    public void shouldRegisterPatient() throws InterruptedException {
        //Arrange
        shouldLogin();
        operationsPage.RegistrationDesk(webDriver);
        RegisterPatient registerPatient = new RegisterPatient(webDriver);
        //Act
        registerPatient.formFillOut();
    }

    @Test
    public void shouldSearchForPatient() throws InterruptedException {
        //Arrange
        shouldLogin();
        String visitDate = "07.Sep.2023";
        String pTemp = "97";
        //Act
        operationsPage.patientDetails(webDriver);
        searchPatient.findPatientByIdOrName();
        //Assert
        Assert.assertEquals(searchPatient.getVisitDetails(),visitDate);
        Assert.assertEquals(searchPatient.getTempDetails(),pTemp);
    }

    @Test
    public void shouldManagePrivileges() throws InterruptedException {
        //Arrange
        shouldLogin();
        //Act
        operationsPage.configureData(webDriver);
        privileges.managePrivileges();
        privileges.addPrivileges();
        privileges.searchPrivileges();
        //Assert
        Assert.assertEquals(privileges.assertionSelectors(),"Add Encounters","The added privilege name does not match");

    }

    @Test
    public void shouldScheduleAppointments() throws InterruptedException {
        //Arrange
        shouldLogin();
        //Act
        operationsPage.AppointmentScheduling();
        Appointment appointment =new Appointment(webDriver);
        appointment.goToServices();
        Assert.assertEquals(appointment.getDuration(),"10");
        appointment.addNewServiceType();
        Assert.assertFalse(appointment.getDuration().equals(appointment.editDuration()));

        //Assert
    }


    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }
}
