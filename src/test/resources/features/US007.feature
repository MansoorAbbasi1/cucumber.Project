@US007
Feature: US007 Hastalar randevu tarihi oluşturabilmelidir.
  Background: Ortak adimlar

 Given Kullanici anasayfaya gider
  When Kullanici profil simgesine tiklar
  And  Kullanici sing in sekmesine tiklar
  And  Kullanici valid username ve valid password girisi yapar
  And  Kullanici sing in butonuna tiklar
  Then Kullanici My Pages secenegine tiklar
  And  Kullanici acilan dropdownda Make an Appointment secenegine tiklar

@4
Scenario Outline: TC01 Kullanıcı gecerli tarih girmelidir. (guncel tarihi veya gelecekteki tarihleri secebilmelidir)(Postive)
  And  Kullanici Phone ve tarih texbox' larini doldurur
  Then Kullanici Appointment Date Time kismina guncel veya gelecektekti bir "<tarih>" girer
  And  Kullanici send an Appointment request  tiklar
  Then Kullanici Appointment registration saved yazisini gorur
  And sayfayi kapatir
  Examples:
    | tarih |
    | 26-12-2022 |

@3
  Scenario Outline: TC01 Kullanıcı gecerli tarih girmelidir. (guncel tarihi veya gelecekteki tarihleri secebilmelidir) (Negative)
    And  Kullanici Phone ve tarih texbox' larini doldurur
  Then Kullanici Appointment Date Time kismina "<gecmisTarih>" girer
    Then Appointment date can not be past date! yazisini goruldugu test edilir
    And  Kullanici send an Appointment request  tiklar
    Then Kullanici Appointment registration saved yazisini gorur
    Then gecmis tarihin kayit edilemdigi test edilir
    And sayfayi kapatir

  Examples:
    |gecmisTarih  |
    |20-11-2022  |

  @1
 Scenario Outline: TC02 Tarih sirasi gun/ay/yil (ay/gun/yil) seklinde olmalidir.
    Then Tarih sirasini "<gun-ay-yil>" seklinde oldugu test edilir
    And sayfayi kapatir
    Examples:
      | gun-ay-yil |
      | 18-12-2022 |









