package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.MedunnaPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;


public class US007 {
    MedunnaPages medunnaPages=new MedunnaPages();
    Actions actions=new Actions(Driver.getDriver());



    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
    @Given("Kullanici anasayfaya gider")
    public void kullaniciAnasayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @When("Kullanici profil simgesine tiklar")
    public void kullaniciProfilSimgesineTiklar() {
       medunnaPages.userSignIcon.click();
        ReusableMethods.waitFor(2);
    }

    @And("Kullanici sing in sekmesine tiklar")
    public void kullaniciSingInSekmesineTiklar() {
        medunnaPages.logSignin.click();
        ReusableMethods.waitFor(2);
    }

    @And("Kullanici valid username ve valid password girisi yapar")
    public void kullaniciValidUsernameVeValidPasswordGirisiYapar() {
        medunnaPages.signinUsername.sendKeys(ConfigReader.getProperty("gecerliUsername"));
        ReusableMethods.waitFor(1);
        medunnaPages.signinPassword.sendKeys(ConfigReader.getProperty("gecerliPassword"));
    }

    @And("Kullanici sing in butonuna tiklar")
    public void kullaniciSingInButonunaTiklar() {
        ReusableMethods.waitFor(1);
        medunnaPages.signInButton.click();
        ReusableMethods.waitFor(1);


    }

    @Then("Kullanici My Pages secenegine tiklar")
    public void kullaniciMyPagesSecenegineTiklar() {
        //javascriptExecutor.executeScript("arguments[0].click();",medunnaPages.dropDownMyPages);
        //actions.moveToElement(medunnaPages.dropDownMyPages).perform();
        //actions.click(medunnaPages.dropDownMyPages).perform();
        ReusableMethods.waitForVisibility(medunnaPages.myPages,3);
        medunnaPages.myPages.click();
        ReusableMethods.waitFor(3);

    }

    @And("Kullanici acilan dropdownda Make an Appointment secenegine tiklar")
    public void kullaniciAcilanDropdowndaMakeAnAppointmentSecenegineTiklar() {
        //actions.click(medunnaPages.patientMakeAppointment).perform();
        medunnaPages.patientMakeAppointment.click();
        ReusableMethods.waitFor(3);

    }

    @And("Kullanici Phone ve tarih texbox' larini doldurur")
    public void kullaniciPhoneTexboxiniDoldurur() {
        medunnaPages.patientPhone.sendKeys(ConfigReader.getProperty("patientPhone"));
        ReusableMethods.waitFor(1);
    }

    @Then("Kullanici Appointment Date Time kismina guncel veya gelecektekti bir {string} girer")
    public void kullaniciAppointmentDateTimeKisminaGuncelVeyaGelecektektiBirGirer(String tarih) {
       /* if (n.equals("g")){
            medunnaPages.patientTarih.sendKeys(LocalDate.now().toString());
        }else if (n.equals("i")){
            medunnaPages.patientTarih.sendKeys(LocalDate.now().plusDays(3).toString());

        }
        ReusableMethods.waitFor(1);

        */

        //medunnaPages.patientTarih.sendKeys(LocalDate.now().toString());
        //ReusableMethods.waitFor(3);

        medunnaPages.patientTarih.sendKeys(tarih);
    }


    @And("Kullanici send an Appointment request  tiklar")
    public void kullaniciSendAnAppointmentRequestTiklar() {
        medunnaPages.sendAppointmentButton.click();
        ReusableMethods.waitFor(1);
    }

    @Then("Kullanici Appointment registration saved yazisini gorur")
    public void kullaniciAppointmentRegistrationSavedYazisiniGorur() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(medunnaPages.sendAppointmentText.isDisplayed());
    }

    @Then("Kullanici Appointment Date Time kismina {string} girer")
    public void kullaniciAppointmentDateTimeKisminaGirer(String gecmisTarih) {
        medunnaPages.patientTarih.sendKeys(gecmisTarih);

    }
    //@Then("Kullanici Appointment Date Time kismina gecmis tarih girer")
    //public void kullaniciAppointmentDateTimeKisminaGecmisTarihGirer() {
      //  medunnaPages.patientTarih.sendKeys(LocalDate.now().minusDays(3).toString());}

    @Then("Appointment date can not be past date! yazisini goruldugu test edilir")
    public void appointmentDateCanNotBePastDateYazisiniGorulduguTestEdilir() throws IOException {
        Assert.assertTrue(medunnaPages.gecmisTarihUyarisi.isDisplayed());
        ReusableMethods.getScreenshot("Appointment Tarihi");

    }

    @Then("gecmis tarihin kayit edilemdigi test edilir")
    public void gecmisTarihinKayitEdilemdigiTestEdilir() throws IOException {

        Assert.assertTrue(medunnaPages.sendAppointmentText.isDisplayed());
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Appointment Tarihi");
    }

   /* @Then("Tarih sirasini gun,ay,yil seklinde oldugu test edilir")
    public void tarihSirasiniGunAyYilSeklindeOlduguTestEdilir() {
       // medunnaPages.patientTarih.clear();
        //ReusableMethods.waitFor(1);
        //String tarih=medunnaPages.patientTarih.getAttribute("value");
        //System.out.println("tarih = " + tarih);
        LocalDate tarihSaat= LocalDate.now(ZoneId.of(medunnaPages.patientTarih.getText().toString()));

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("dtf2.format(tarihSaat) = " + dtf2.format(tarihSaat));


        ReusableMethods.waitFor(3);

    }

    */


    @And("sayfa {int} saniye bekletilir.")
    public void sayfaSaniyeBekletilir(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }


    @Then("Tarih sirasini {string} seklinde oldugu test edilir")
    public void tarihSirasiniSeklindeOlduguTestEdilir(String tarih) {
        medunnaPages.patientTarih.sendKeys(tarih);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(medunnaPages.patientTarih.isDisplayed());
    }
}
