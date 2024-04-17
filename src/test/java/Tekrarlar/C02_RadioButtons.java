package Tekrarlar;

import Utilites.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_RadioButtons {

    static WebDriver driver;
    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void tearDown(){

        ReusableMethod.beklemeSuresi(3);
        driver.quit();
    }
    @Test
    public void radioButtonTesti(){

        //a. Verilen web sayfasına gidin.
        //https://facebook.com
        driver.get("https://facebook.com");
        ReusableMethod.beklemeSuresi(1);
        //b. Cookies’i kabul edin
        //c. Create an account buton’una basin
        WebElement hesapOlusturButonu = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        hesapOlusturButonu.click();
        ReusableMethod.beklemeSuresi(2);
        //d. Radio button elementlerini locate edin ve size uygun olani secin
        List<WebElement> cinsiyetlerSecimi = driver.findElements(By.xpath("//label[@class='_58mt']"));
        cinsiyetlerSecimi.get(0).click();
        ReusableMethod.beklemeSuresi(2);
        //e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        System.out.println("kontrolll *************");
        Assert.assertTrue(cinsiyetlerSecimi.get(0).isSelected()&& !(cinsiyetlerSecimi.get(1).isSelected())&&
                                       !(cinsiyetlerSecimi.get(2).isSelected()) );
    }
}
