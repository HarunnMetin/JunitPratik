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

public class C05_ornek {

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(17));

    }
    @AfterClass
    public static void tearDown(){

        ReusableMethod.beklemeSuresi(3);
        driver.quit();
    }

    @Test
    public void saucedemoTest(){

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        WebElement username = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]"));
        username.sendKeys("standard_user"+ Keys.ENTER);
        ReusableMethod.beklemeSuresi(3);

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce"+Keys.ENTER);
        ReusableMethod.beklemeSuresi(3);

        //4. Login tusuna basin
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement webElement = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        String urunIsmi = webElement.getText();

        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='inventory_item_img'])[1]"));
        ilkUrun.click();
        //6. Add to Cart butonuna basin
        WebElement addToCardButton = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
        addToCardButton.click();
        //7. Alisveris sepetine tiklayin
        WebElement alisverisSepeti = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        alisverisSepeti.click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepetKontrol = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        if (sepetKontrol.isDisplayed()){
            System.out.println("sectiginiz urun basariyla kaydedildi TEST PASSED");
        }
        else{
            System.out.println("sectiginiz urun kaydedilmedi TEST FAILED");
        }
        //9. Sayfayi kapatin
    }


}
