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

public class C01_CheckBox {

    static WebDriver driver;
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(17));

    }
    @After
    public void tearDown(){
        ReusableMethod.beklemeSuresi(3);
        driver.quit();
    }

    @Test
    public void herokuappTesti(){

        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        ReusableMethod.beklemeSuresi(2);
        if (!checBox1.isSelected()){
            checBox1.click();
        }
        ReusableMethod.beklemeSuresi(2);
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checBox2.isSelected()){
            checBox2.isSelected();
        }
        ReusableMethod.beklemeSuresi(2);
        //e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(checBox1.isSelected() && checBox2.isSelected());
    }

}
