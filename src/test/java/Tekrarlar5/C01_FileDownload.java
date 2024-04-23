package Tekrarlar5;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Path;

public class C01_FileDownload extends TestBase {

    @Test
    public void fileTestleri(){

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim
        WebElement dosya = driver.findElement(By.xpath("//a[text()='logo.png']"));
        dosya.click();
        ReusableMethod.beklemeSuresi(5);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaKonumu = "C:\\Users\\acer";
        Assert.assertTrue(Files.exists(Path.of(dosyaKonumu)));
    }
}
