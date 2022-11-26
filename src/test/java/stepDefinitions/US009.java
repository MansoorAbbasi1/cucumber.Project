package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.MedunnaPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US009 {
    MedunnaPages medunnaPages = new MedunnaPages();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @And("Personel username girilir.")
    public void personelUsernameGirilir() {
        medunnaPages.signinUsername.sendKeys(ConfigReader.getProperty("staffGecerliUsername"));
        ReusableMethods.waitFor(1);
    }

    @And("Personel password girilir.")
    public void personelPasswordGirilir() {
        medunnaPages.signinPassword.sendKeys(ConfigReader.getProperty("staffGecerliPassword"));
        ReusableMethods.waitFor(1);
    }


    @And("Search patient'e tiklanir.")
    public void searchPatientETiklanir() {
        medunnaPages.searchPatientButton.click();
        ReusableMethods.waitFor(1);
    }

    @Then("Patient ssn box'a ssn girilir.")
    public void patientSsnBoxASsnGirilir() {
        medunnaPages.patientSearchBox.sendKeys(ConfigReader.getProperty("PatientSSN"));
        ReusableMethods.waitFor(3);
    }

    @And("View'e tiklanir.")
    public void viewETiklanir() {
        medunnaPages.viewButton.click();
        ReusableMethods.waitFor(1);
    }

    @Then("Hasta bilgilerinin goruldugu test edilir.")
    public void hastaBilgilerininGorulduguTestEdilir() {
        Assert.assertTrue(medunnaPages.hastaBilgilerSayfasi.isDisplayed());
    }

    @And("Edit butonuna tiklanir.")
    public void editButonunaTiklanir() {
        medunnaPages.editButton.click();
    }


    @Then("firstname, lastname, birthdate, email, phone, gender, blood group, address, description, user, country and state-city bilgileri duzenlenir")
    public void firstnameLastnameBirthdateEmailPhoneGenderBloodGroupAddressDescriptionUserCountryAndStateCityBilgileriDuzenlenir() {

        medunnaPages.editPatientFirstName.clear();

        actions.click(medunnaPages.editPatientFirstName).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).perform();
        ReusableMethods.waitFor(1);
        medunnaPages.editPatientEmail.clear();
        medunnaPages.editPatientEmail.sendKeys(faker.internet().emailAddress());
        medunnaPages.editPatientPhone.clear();
        medunnaPages.editPatientPhone.sendKeys(faker.phoneNumber().cellPhone());
        actions.sendKeys(Keys.TAB).
                sendKeys("M").sendKeys(Keys.TAB).sendKeys("b").sendKeys(Keys.TAB)
                .sendKeys(faker.lorem().characters(10)).sendKeys(Keys.TAB)
                .sendKeys(faker.lorem().characters(10)).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

    }

    @And("Save butonuna tiklanir.")
    public void saveButonunaTiklanir() {
        ReusableMethods.waitFor(2);
        medunnaPages.editSaveButton.click();
    }


    @Then("firstname, lastname, birthdate, email, phone, gender, blood group,address, description, user, country and state-city bilgilerin duzenlenebildigi test edilir")
    public void firstnameLastnameBirthdateEmailPhoneGenderBloodGroupAddressDescriptionUserCountryAndStateCityBilgilerinDuzenlenebildigiTestEdilir() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(medunnaPages.editSaveBasariliText.isDisplayed());
        ReusableMethods.waitFor(2);
    }


    @Then("Ssn girilerek aranabildigi test edilmeli")
    public void ssnGirilerekAranabildigiTestEdilmeli() {

        for (WebElement each :medunnaPages.ssnElements) {
            Assert.assertTrue(each.isDisplayed());
        }
        ReusableMethods.waitFor(2);
    }

    @Then("Tum kayit bilgilerinin dolduruldugu test edilir.")
    public void tumKayitBilgilerininDoldurulduguTestEdilir() {
        for (WebElement each: medunnaPages.tumKayitBilgileri) {
            Assert.assertTrue(each.isDisplayed());
        }
        ReusableMethods.waitFor(2);
    }


    @Then("Delete butonu yok\\(bug)")
    public void deleteButonuYokBug() throws IOException {
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Delete butonu yok");
        ReusableMethods.waitFor(1);
    }
}
