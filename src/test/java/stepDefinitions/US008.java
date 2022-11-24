package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.MedunnaPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US008 {
    MedunnaPages medunnaPages = new MedunnaPages();
    Actions action = new Actions(Driver.getDriver());
    @And("Password butonuna tiklar")
    public void passwordButonunaTiklar() {
        medunnaPages.SifreButton.click();
        ReusableMethods.waitFor(3);

    }

    @Then("Kullanici Current password textboxina eski sifresini yazar.")
    public void kullaniciCurrentPasswordTextboxinaEskiSifresiniYazar() {
        medunnaPages.currentPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliPassword"));
    }

    @And("Kullanici New password textboxina yeni sifresini yazar.")
    public void kullaniciNewPasswordTextboxinaYeniSifresiniYazar() {
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliYeniPassword"));
    }

    @And("New password confirmation textboxina yeni sifresini yazar")
    public void newPasswordConfirmationTextboxinaYeniSifresiniYazar() {
        medunnaPages.newConfirmPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliYeniPassword"));
    }

    @And("Kaydet butonuna tiklar")
    public void kaydetButonunaTiklar() {
        medunnaPages.saveButton.click();
    }

    @Then("Password changed! basari yazisinin geldigini dogrular")
    public void passwordChangedBasariYazisininGeldiginiDogrular() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(medunnaPages.passwordChangedText.isDisplayed());
    }

    @And("ilk gecerli sifreye sifirlayalim")
    public void ilkGecerliSifreyeSifirlayalim() {
        ReusableMethods.waitFor(1);
        medunnaPages.currentPasswordKutusu.clear();
        ReusableMethods.waitFor(1);
        medunnaPages.currentPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliYeniPassword"));
        ReusableMethods.waitFor(1);
        medunnaPages.newPasswordKutusu.clear();
        ReusableMethods.waitFor(1);
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        ReusableMethods.waitFor(1);
        medunnaPages.newConfirmPasswordKutusu.clear();
        ReusableMethods.waitFor(1);
        medunnaPages.newConfirmPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        ReusableMethods.waitFor(1);
        medunnaPages.saveButton.click();

    }

    @Then("Kullanici New password confirmation textboxini temizler")
    public void kullaniciNewPasswordConfirmationTextboxiniTemizler() {
        ReusableMethods.waitFor(2);
        medunnaPages.newConfirmPasswordKutusu.clear();
    }

    @Given("New password confirmation textboxina new password'den farkli bir sifre yazar")
    public void newPasswordConfirmationTextboxinaNewPasswordDenFarkliBirSifreYazar() {
        ReusableMethods.waitFor(1);
        medunnaPages.newConfirmPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliYeni2Password"));
    }

    @Given("The password and its confirmation do not match! uyarisini gormelidir")
    public void thePasswordAndItsConfirmationDoNotMatchUyarisiniGormelidir() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(medunnaPages.yeniPasswordConfirmationTextUyarisi.isDisplayed());
    }

    @And("Kullanici New password textbaxina alti tane buyuk harf gonderir")
    public void kullaniciNewPasswordTextbaxinaAltiTaneBuyukHarfGonderir() {
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("AltiTaneBuyukHarf"));
    }

    @And("Password strength' in bir dis oldugunu dogrular")
    public void passwordStrengthInBirDisOldugunuDogrular() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(medunnaPages.passwordStrength1.isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @And("New password textbaxina herhangi bir kucuk harf ekler")
    public void newPasswordTextbaxinaHerhangiBirKucukHarfEkler() {
        ReusableMethods.waitFor(1);
        medunnaPages.newPasswordKutusu.clear();
        ReusableMethods.waitFor(2);
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("AltiTaneBuyukHarf+birTaneKucukHarf"));
    }

    @And("Password strength' in iki dis oldugunu dogrular")
    public void passwordStrengthInIkiDisOldugunuDogrular() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(medunnaPages.passwordStrength2.isDisplayed());
    }

    @Given("Kullanici New password textbaxina alti tane kucuk harf gonderir")
    public void kullaniciNewPasswordTextbaxinaAltiTaneKucukHarfGonderir() {
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("AltiTaneKucukHarf"));
        ReusableMethods.waitFor(1);
    }

    @Given("New password textbaxina herhangi bir buyuk harf ekler")
    public void newPasswordTextbaxinaHerhangiBirBuyukHarfEkler() {
        ReusableMethods.waitFor(1);
        medunnaPages.newPasswordKutusu.clear();
        ReusableMethods.waitFor(1);
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("AltiTaneKucukHarf+birTaneHarfHarf"));
    }


    @Given("Kullanici New password textbaxina proTEAM karakterlerini gonderir")
    public void kullaniciNewPasswordTextbaxinaProTEAMKarakterleriniGonderir() {
        medunnaPages.newPasswordKutusu.sendKeys("proTEAM");
    }

    @Given("New password textbaxina herhangi bir rakam ekler")
    public void newPasswordTextbaxinaHerhangiBirRakamEkler() {
        ReusableMethods.waitFor(1);
        medunnaPages.newPasswordKutusu.clear();
        ReusableMethods.waitFor(2);
        medunnaPages.newPasswordKutusu.sendKeys("proTEAM9");
    }

    @Given("Password strength' in dort dis oldugunu dogrular")
    public void passwordStrengthInDortDisOldugunuDogrular() {
        Assert.assertTrue(medunnaPages.passwordStrength4.isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @And("Kullanici New password textbaxina Alti karakter gonderir")
    public void kullaniciNewPasswordTextbaxinaAltiKarakterGonderir() {
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("AltiKarakter"));
        ReusableMethods.waitFor(1);
    }

    @And("New password textbaxina herhangi bir ozel karakter ekler")
    public void newPasswordTextbaxinaHerhangiBirOzelKarakterEkler() {
        ReusableMethods.waitFor(1);
        medunnaPages.newPasswordKutusu.clear();
        ReusableMethods.waitFor(1);
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("AltiKarakter+birOzelKarakter"));
    }

    @Then("Password strength' in bes dis oldugunu dogrular")
    public void passwordStrengthInBesDisOldugunuDogrular() {
        Assert.assertTrue(medunnaPages.passwordStrength5.isDisplayed());
        ReusableMethods.waitFor(3);
    }

    @And("Kullanici New password textbaxina yedi karakterden az rakam,ozel karakter ve harf girilir")
    public void kullaniciNewPasswordTextbaxinaYediKarakterdenAzRakamOzelKarakterVeHarfGirilir() {
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("AltiKarakter"));

    }

    @And("Kullanici New password textbaxina Buyuk, kucuk harf, rakam, Alti karakter girilir.")
    public void kullaniciNewPasswordTextbaxinaBuyukKucukHarfRakamAltiKarakterGirilir() {
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("AltiKarakter"));
    }


    @And("Kullanici New password textboxina eski sifresini yazar.")
    public void kullaniciNewPasswordTextboxinaEskiSifresiniYazar() {
        medunnaPages.newPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        ReusableMethods.waitFor(2);

    }

    @And("New password confirmation textboxina eski sifresini yazar")
    public void newPasswordConfirmationTextboxinaEskiSifresiniYazar() {
        medunnaPages.newConfirmPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        ReusableMethods.waitFor(2);

    }

    @Then("Password changed! basari yazisinin geldigini bir bug olarak dogrular")
    public void passwordChangedBasariYazisininGeldiginiBirBugOlarakDogrular() throws IOException {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(medunnaPages.passwordChangedText.isDisplayed());
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Password changed! bug");
    }
}
