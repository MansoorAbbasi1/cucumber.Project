@US009
Feature: US009 Staff (Personel), hasta bilgilerini görebilmeli, düzenleyebilmeli ama silememelidir.
  Background: Ortak adimlar
    Given Kullanici anasayfaya gider
    When  Kullanici profil simgesine tiklar
    And   Kullanici sing in sekmesine tiklar
    And   Personel username girilir.
    And   Personel password girilir.
    And   Kullanici sing in butonuna tiklar
    Then  Kullanici My Pages secenegine tiklar
    And   Search patient'e tiklanir.
    Then  Patient ssn box'a ssn girilir.



    Scenario: TC01 "My Pages" sekmesinden hasta bilgilerini görebilmelidir.
    And   View'e tiklanir.
    Then  Hasta bilgilerinin goruldugu test edilir.
    And   sayfayi kapatir

      @20
    Scenario: TC02 Kullanıcı bütün hasta bilgilerini "id, firstname, lastname, birthdate, email, phone, gender, blood group,
              address, description, user, country and state/city" düzenleyebilmelidir.
    And  Edit butonuna tiklanir.
    Then firstname, lastname, birthdate, email, phone, gender, blood group, address, description, user, country and state-city bilgileri duzenlenir
    And  Save butonuna tiklanir.
    Then firstname, lastname, birthdate, email, phone, gender, blood group,address, description, user, country and state-city bilgilerin duzenlenebildigi test edilir
    And  sayfayi kapatir

    @21
    Scenario: TC03 Kullanıcı, SSN'lerine göre yeni bir başvuru sahibi arayabilmeli ve tüm kayıt bilgilerinin doldurulduğunu görebilmelidir.
    Then Ssn girilerek aranabildigi test edilmeli
    Then Tum kayit bilgilerinin dolduruldugu test edilir.
    And  sayfayi kapatir

    @22
    Scenario: TC04 Kullanıcı herhangi bir hasta bilgisini silebilir.
    Then Delete butonu yok(bug)
    And  sayfayi kapatir
