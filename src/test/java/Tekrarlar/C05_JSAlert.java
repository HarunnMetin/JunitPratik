package Tekrarlar;

import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utilites.ReusableMethod.beklemeSuresi;

public class C05_JSAlert extends TestBase {


    @Test
    public void test1(){

        //1. Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        beklemeSuresi(2);
        //- 1.alert'e tiklayin
        WebElement birinciAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        birinciAlert.click();
        beklemeSuresi(2);
        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertTrue(actualAlertYazisi.contains(expectedAlertYazisi));
        beklemeSuresi(3);
        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }
    @Test
    public void test2(){

        //2.Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        beklemeSuresi(2);
        //- 2.alert'e tiklayalim
        WebElement ikinciAlert = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        ikinciAlert.click();
        beklemeSuresi(2);
        //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        beklemeSuresi(2);
        WebElement sonucYazisi = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucyazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucyazisi.contains(expectedSonucYazisi));


    }
    @Test
    public void test3(){

        //3.Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        beklemeSuresi(2);
        //- 3.alert'e tiklayalim
        WebElement ucuncuAlert = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        ucuncuAlert.click();
        beklemeSuresi(2);
        //- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        beklemeSuresi(3);
        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        beklemeSuresi(2);
        //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebElement sonucYazisi = driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains("Abdullah"));

    }


    //3 test method'u olusturup asagidaki gorevi tamamlayin
    //1. Test
    //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //- 1.alert'e tiklayin
    //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
    //- OK tusuna basip alert'i kapatin
    //2.Test
    //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //- 2.alert'e tiklayalim
    //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    //3.Test
    //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //- 3.alert'e tiklayalim
    //- Cikan prompt ekranina "Abdullah" yazdiralim
    //- OK tusuna basarak alert'i kapatalim
    //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
}
