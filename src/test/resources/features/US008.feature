@US008
Feature: US008 Kullanıcı giriş yaptığında Password sekmesi düzenlenebilir olmalıdır.
  Background: Ortak adimlar
  Given Kullanici anasayfaya gider
  When  Kullanici profil simgesine tiklar
  And   Kullanici sing in sekmesine tiklar
  And   Kullanici valid username ve valid password girisi yapar
  And   Kullanici sing in butonuna tiklar
  Then  Kullanici profil simgesine tiklar
  And   Password butonuna tiklar

@10
  Scenario: TC01 kullanici sifresini degistirebilmelidir (Pozitif Seneryo)
  Then  Kullanici Current password textboxina eski sifresini yazar.
  And   Kullanici New password textboxina yeni sifresini yazar.
  And   New password confirmation textboxina yeni sifresini yazar
  And   Kaydet butonuna tiklar
  Then  Password changed! basari yazisinin geldigini dogrular
  And   ilk gecerli sifreye sifirlayalim
  And   sayfayi kapatir

@11
  Scenario: TC02 kullanici sifresini degistirebilmelidir (Negatif Seneryo)
    And   Kullanici New password confirmation textboxini temizler
    And   New password confirmation textboxina new password'den farkli bir sifre yazar
    And   Kaydet butonuna tiklar
    Then  The password and its confirmation do not match! uyarisini gormelidir
    And   sayfayi kapatir

  @12
  Scenario: TC03 Daha guclu sifre icin en az 1 kucuk harf olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
  And   Kullanici New password textbaxina alti tane buyuk harf gonderir
  Then  Password strength' in bir dis oldugunu dogrular
  And   New password textbaxina herhangi bir kucuk harf ekler
  Then  Password strength' in iki dis oldugunu dogrular
    And sayfayi kapatir

    @13
  Scenario: TC04 Sifre en az 1 buyuk harf icermeli ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    And   Kullanici New password textbaxina alti tane kucuk harf gonderir
    Then  Password strength' in bir dis oldugunu dogrular
    And   New password textbaxina herhangi bir buyuk harf ekler
    Then  Password strength' in iki dis oldugunu dogrular
      And   sayfayi kapatir

 @14
  Scenario: TC05 Sifre en az 1 rakam icermeli ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    And   Kullanici New password textbaxina proTEAM karakterlerini gonderir
    Then  Password strength' in iki dis oldugunu dogrular
    And   New password textbaxina herhangi bir rakam ekler
    Then  Password strength' in dort dis oldugunu dogrular
    And   sayfayi kapatir
@15
  Scenario: TC06 Sifre en az 1 ozel karakter icermeli ve"Password strength:" seviyesinin degistigi gorulebilmelidir.
    And   Kullanici New password textbaxina Alti karakter gonderir
    Then  Password strength' in bir dis oldugunu dogrular
    And   New password textbaxina herhangi bir ozel karakter ekler
    Then  Password strength' in bes dis oldugunu dogrular
    And   sayfayi kapatir
@16
  Scenario: TC07 Guclu bir parola icin sifre en az 7 karakterden olusmalidir. (Negatif Senaryo)
    And   Kullanici New password textbaxina yedi karakterden az rakam,ozel karakter ve harf girilir
    Then  Password strength' in bir dis oldugunu dogrular
    And   sayfayi kapatir

@17
  Scenario: TC08 Guclu bir parola icin sifre en az 7 karakterden olusmalidir. (Pozitif Senaryo)
  And  Kullanici New password textbaxina Buyuk, kucuk harf, rakam, Alti karakter girilir.
  Then Password strength' in bir dis oldugunu dogrular
  Then New password textbaxina herhangi bir ozel karakter ekler
  Then Password strength' in bes dis oldugunu dogrular
  And   sayfayi kapatir
@18
    Scenario: TC09 (Eski şifre kullanılmamalıdır.)Eski sifre yeni sifre olarak kayit edilememelidir
    And  Kullanici Current password textboxina eski sifresini yazar.
    And  Kullanici New password textboxina eski sifresini yazar.
    And  New password confirmation textboxina eski sifresini yazar
    And  Kaydet butonuna tiklar
    Then Password changed! basari yazisinin geldigini bir bug olarak dogrular
    And  sayfayi kapatir











