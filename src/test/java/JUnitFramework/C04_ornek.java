package JUnitFramework;

import Utilites.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ornek {

    static WebDriver driver;
    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));

    }
    @AfterClass
    public static void tearDown(){
        ReusableMethod.beklemeSuresi(3);
        driver.quit();
    }
    @Test
    public void ornekTest(){

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("baslık google iceriyor TEST PASSED");
        }
        else {
            System.out.println("baslık google icermiyor TEST FAILED");
        }
        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaCubugu.sendKeys("Nutella"+ Keys.ENTER);
        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucText = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonucYazisi = sonucText.getText();
        System.out.println(sonucYazisi);
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisi = sonucYazisi.split(" ")[1].replace(".", "");
        int sonucSonHali = Integer.parseInt(sonucSayisi);
        if (sonucSonHali>10000000){
            System.out.println(sonucSonHali +" : 10 milyondan buyuk TEST PASSED");
        }
        else {
            System.out.println(sonucSonHali +" : 10 milyondan kucuk TEST FAILED");
        }
        //8- Sayfayi kapatin

    }
}
