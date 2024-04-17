package JUnitFramework;

import Utilites.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ornek {

    static WebDriver driver;
    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");

    }
    @AfterClass
    public static void rearDown(){

        ReusableMethod.beklemeSuresi(3);
        driver.quit();
    }

    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void titleTesti(){
        String expectetTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectetTitle));

    }
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void resimTesti(){

        WebElement resim = driver.findElement(By.xpath("(//a[@id='logo'])[1]"));
        Assert.assertTrue(resim.isDisplayed());

    }
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void searchBoxTesti(){

        WebElement searcBox= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searcBox.isEnabled());

    }


    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void sayfaBasligi(){

        String expectedBaslik = "youtube";
        String actualBaslik = driver.getTitle();
        Assert.assertFalse(actualBaslik.contains(expectedBaslik));

    }





}
