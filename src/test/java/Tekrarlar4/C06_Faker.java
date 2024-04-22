package Tekrarlar4;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_Faker extends TestBase {

    Actions actions;
    Faker faker;
    @Test
    public void fakerTesti(){


        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //2. “create new account” butonuna basin
        WebElement yeniHesapButonu = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        yeniHesapButonu.click();
        ReusableMethod.beklemeSuresi(3);

        //3. “firstName” giris kutusuna bir isim yazin

        String email = faker.internet().emailAddress();

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));

        actions.click(firstName)

                .sendKeys("harun")
                .sendKeys(Keys.TAB)
                .sendKeys("metin")

                .perform();

        ReusableMethod.beklemeSuresi(5);

        //4. “surname” giris kutusuna bir soyisim yazin
        //5. “email” giris kutusuna bir email yazin
        //6. “email” onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin
        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        //11. Cinsiyeti secin
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //13. Sayfayi kapatin
    }

}
