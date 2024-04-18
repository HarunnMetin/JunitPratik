package Tekrarlar3;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class C04_KontrolsuzCokluWindow extends TestBase {


    @Test
    public void cokluPencere(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        ReusableMethod.beklemeSuresi(1);
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String expectetText = "Opening a new window";
        String actualText = text.getText();
        Assert.assertTrue(actualText.contains(expectetText));
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualText.contains(expectetText));


        String anaSayfaHandleDegeri = driver.getWindowHandle();

        //● Click Here butonuna basın.
        WebElement clickHereButonu = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereButonu.click();
        ReusableMethod.beklemeSuresi(3);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Set<String> windowHandles = driver.getWindowHandles();
        for (String each:windowHandles) {
            if (!each.contains(anaSayfaHandleDegeri)){
                driver.switchTo().window(each);
            }
        }
        WebElement yeniPencere = driver.findElement(By.xpath("//h3[text()='New Window']"));
        String expectedYeniPencereTitle = "New Window";
        String actualYeniPencereTitle = driver.getTitle();
        Assert.assertTrue(actualYeniPencereTitle.contains(expectedYeniPencereTitle));

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedSayfadakiText = "New Window";
        String actualSayfadakiText = yeniPencere.getText();
        Assert.assertTrue(actualSayfadakiText.contains(expectedSayfadakiText));
        ReusableMethod.beklemeSuresi(2);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
    }
}
