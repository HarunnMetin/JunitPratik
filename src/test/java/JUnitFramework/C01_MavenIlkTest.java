package JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
        driver.navigate().refresh();
        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        Thread.sleep(1000);
        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonuc = driver.findElement(By.xpath("//span[text()='1-16 of over 1,000 results for']"));
        System.out.println(sonuc.getText());

        //5- Ilk urunu tiklayalim
        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
        ilkUrun.click();
        //6- Onceki sayfaya donup, sayfadaki tum basliklari yazdiralim
        driver.navigate().back();
        Thread.sleep(3000);
        driver.close();
    }
}
