package JUnitFramework;

import Utilites.ReusableMethod;
import Utilites.TestBaseBeforClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ornek  {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. http://zero.webappsecurity.com sayfasina gidin

        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        WebElement singinButonu = driver.findElement(By.xpath("//button[@id='signin_button']"));
        singinButonu.click();
        ReusableMethod.beklemeSuresi(2);
        //3. Login alanine “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username"+ Keys.ENTER);
        ReusableMethod.beklemeSuresi(3);

        //4. Password alanina “password” yazdirin
        WebElement pasword = driver.findElement(By.xpath("//input[@id='user_password']"));
        pasword.sendKeys("password"+Keys.ENTER);
        //5. Sign in buttonuna tiklayin
        WebElement singInButton = driver.findElement(By.xpath("//input[@name='submit']"));
        singInButton.click();
        //6. Back tusu ile sayfaya donun
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //9. tarih kismina “2020-09-10” yazdirin
        //10. Pay buttonuna tiklayin
        //11. “The payment was successfully submitted.” mesajinin
        //ciktigini test edin


    }
}
