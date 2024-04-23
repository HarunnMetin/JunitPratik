package Tekrarlar4;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C09_Ornek extends TestBase {

    Actions actions;
    @Test
    public void ornekSoruTesti(){

        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);

        WebElement ourProduct = driver.findElement(By.xpath("//a[text()='Our Products']"));
        ourProduct.click();
        ReusableMethod.beklemeSuresi(2);

        //3. “Cameras product”i tiklayin
        WebElement cameras = driver.findElement(By.xpath("//p[text()='Cameras']"));
        cameras.click();
        ReusableMethod.beklemeSuresi(2);

        //4. Popup mesajini yazdirin
        WebElement popUpMesaji = driver.findElement(By.xpath("//div[@class='modal-content']"));
        System.out.println(popUpMesaji.getText());
        ReusableMethod.beklemeSuresi(2);


        //5. “close” butonuna basin
        WebElement closeButtonu = driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
        closeButtonu.click();
        ReusableMethod.beklemeSuresi(2);
        driver.switchTo().defaultContent();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        WebElement link = driver.findElement(By.xpath("//a[text()='WebdriverUniversity.com (IFrame)']"));
        link.sendKeys(Keys.ENTER);
        ReusableMethod.beklemeSuresi(2);

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }
}
