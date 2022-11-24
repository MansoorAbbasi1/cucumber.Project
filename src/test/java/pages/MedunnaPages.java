package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaPages {
    public MedunnaPages() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement dropDownRegister;

    @FindBy(xpath = "//*[@id='account-menu']")
    public WebElement userSignIcon;

    @FindBy(xpath = "//span[text()='Registration']")
    public WebElement registrationText;


    @FindBy(xpath = "//*[@name='firstPassword']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='login-item']")
    public WebElement logSignin;

    @FindBy(xpath = "//*[@name='username']")
    public WebElement signinUsername;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement signinPassword;

    @FindBy(xpath = "//*[@class='form-check form-check-inline']")
    public WebElement rememberme;

    @FindBy(xpath = "//*[@class='alert alert-warning fade show']")
    public WebElement forgetpassword;

    @FindBy(xpath = "//*[@class='alert alert-warning fade show'][2]")
    public WebElement donthave;

    @FindBy(xpath = "//*[@class='btn btn-secondary']")
    public WebElement cancel;

    @FindBy(xpath = "(//span[text()='Sign in'])[3]")
    public WebElement signInButton;

    @FindBy(xpath = "//h1")
    public WebElement wellcomeToMedunnaText;
    @FindBy(xpath = "//*[text()='Failed to sign in!']")
    public WebElement SigningirisYapilamadi;

   // @FindBy (xpath = "(//*[@class='d-flex align-items-center dropdown-toggle nav-link'])[1]")
    //public WebElement patientmyPagesDropDown;

    @FindBy(xpath = "//*[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement dropDownMyPages;


    ////span[text()='MY PAGES']

    @FindBy(xpath = "//*[@id='entity-menu']")
    public WebElement myPages;

    @FindBy (xpath = "(//*[@class='svg-inline--fa fa-calendar-week fa-w-14 fa-fw '])[2]")
    public WebElement patientMakeAppointment;

    @FindBy (xpath = "//*[@id='phone']")
    public WebElement patientPhone;

    @FindBy (xpath = "//*[@id='appoDate']")
    public WebElement patientTarih;

    @FindBy (xpath = "//*[text()='Send an Appointment Request']")
    public WebElement sendAppointmentButton;

    @FindBy (xpath = "//*[text()='Appointment registration saved!']")
    public WebElement sendAppointmentText;


    @FindBy (xpath = "//*[text()='Appointment date can not be past date!']")
    public WebElement gecmisTarihUyarisi;


    //------------- US008------------//

    @FindBy (xpath = "//*[text()='Password']")
    public WebElement SifreButton;

    @FindBy (xpath = "//*[@id='currentPassword']")
    public WebElement currentPasswordKutusu;

    @FindBy (xpath = "//*[@id='newPassword']")
    public WebElement newPasswordKutusu;

    @FindBy (xpath = "//*[@id='confirmPassword']")
    public WebElement newConfirmPasswordKutusu;

    @FindBy (xpath = "//*[@class='btn btn-success']")
    public WebElement saveButton;

    @FindBy (xpath = "//*[text()='Password changed!']")
    public WebElement passwordChangedText;

    @FindBy (xpath = "//*[text()='The password and its confirmation do not match!']")
    public WebElement yeniPasswordConfirmationTextUyarisi;

    @FindBy(xpath = "(//li[@class='point'])[1]")
    public WebElement passwordStrength1;

    @FindBy(xpath = "(//li[@class='point'])[2]")
    public WebElement passwordStrength2;

    @FindBy(xpath = "(//li[@class='point'])[4]")
    public WebElement passwordStrength4;

    @FindBy(xpath = "(//li[@class='point'])[5]")
    public WebElement passwordStrength5;





}
