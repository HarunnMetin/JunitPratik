package JUnitFramework;

import Utilites.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ornek {

    static WebDriver driver;
    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(17));
        driver.get("https://www.bestbuy.com/");

    }
    @AfterClass
    public static void tearDown(){

        ReusableMethod.beklemeSuresi(3);
        driver.quit();
    }

    @Test
    public void urlTest(){

        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

    }
    @Test
    public void baslikTesti(){

        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectetBaslik = "Rest";
        String actualBaslik = driver.getTitle();
        Assert.assertTrue( !actualBaslik.contains(expectetBaslik));

    }
    @Test
    public void logoTesti(){

        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }
    @Test
    public void linkTesti(){

        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement fransizcaLinki = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(fransizcaLinki.isDisplayed());
    }




}
