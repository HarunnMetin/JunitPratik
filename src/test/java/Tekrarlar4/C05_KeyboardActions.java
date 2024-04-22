package Tekrarlar4;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void keyboardActions(){

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Cookies kabul edin

        //3- Yeni hesap olustur butonuna basalim
        WebElement createAccount = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        createAccount.sendKeys(Keys.ENTER);

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim


        WebElement isimKutusu = driver.findElement(By.name("firstname"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("5")
                .sendKeys(Keys.TAB)
                .sendKeys("oct")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();



        ReusableMethod.beklemeSuresi(2);
        //5- Kaydol tusuna basalim
        driver.findElement(By.name("websubmit")).click();
        ReusableMethod.beklemeSuresi(5);
    }
}
