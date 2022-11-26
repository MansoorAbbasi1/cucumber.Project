package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml" },
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@22", // iki tag'ı aynı anda çalıştırmak isterseniz "@gp1 or @gp2"
        dryRun = false
)

public class TestRunner {
    /*
    Runner Class'ı TestNG'deki XMl mantığı ile çalışır. Çalıştırmak istediğimiz senartolara tag belirtiriz
        ve belirttiğimiz tag'ları çalıştırır. XMl deki gibi istediğimiz testleri çalıştırmak için kullanırız.
        Runner class body'si boştur ve runner class'ını ekleyeceğimiz notasyonlar aktive eder.
         Bu class'da kullanacağımız 2 adet notasyon vardır
        -@RunWith(Cucumber.class)  notasyonu Runner class'ına çalışma özelliği ekler.
        Bu notasyon olduğu için Cucumber frameworkumuzde Junit kullanmayı tercih ederiz
        -@CucumberOptions notasyonu içinde
        features : Runeer dosyasının feature dosyasını nereden bulacağını tarif eder
        glue : stepDefinitions yolunu belirtiriz
        tags : Hangi tag'i çalıştırmak istiyorsak onu belli eder

        dryRun : iki seçenek vardır
        dryRun = true; dersek testimizi çalıştırmadan eksik adımları bize verir
        dryRun = false; testlerimizi driver ile çalıştırır.

     */

    /*
Runner class: Cucumber ın olmazsa olmazlarındandır.
Runwith olmazsa olmazdır
CucumberOptions: Junitten geliyor, testlerimizi bu anatotion ile resources-feature da bulunan
Glue kısmı  ile birbirine yapıştırıyoruz, yani feauture fileım ile stepDefinition umu birbirine yapıştırıyorum
Daha sonra tag kısmında feature içinde olusturdugum isimlendirme  kısmını burada çağırıyorum.
dryRun(prova anlamında)= true ile calıstırdığımızda  eksik stepDefinitionları bulmak için kullanıyoruz, browser ı açmadan toolumuza getirir.
                       =false: varsayılan olarak false gelir. Browser calısır. Normal test case lerimizi koşacağımız zaman kullanıyoruz.
 */

    //dryRun:iki secenek var
    //dryRun=true testimizi calistirmadan sadece eksik adimlari bize verir-kontrol eder calistirma yapmaz
    //dryRun=false yazdigimizda testlerimizi calistirir
}
