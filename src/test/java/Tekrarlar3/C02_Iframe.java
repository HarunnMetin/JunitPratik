package Tekrarlar3;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_Iframe extends TestBase {

    @Test
    public void freameTesti(){

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        ReusableMethod.beklemeSuresi(2);
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeSayisi = driver.findElements(By.tagName("iframe"));
        System.out.println("sayfadaki iframe sayisi = "+iframeSayisi.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ilkIframe = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(ilkIframe);
        WebElement youtubePlayVideo = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        youtubePlayVideo.click();
        ReusableMethod.beklemeSuresi(3);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement ikinciIframe = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(ikinciIframe);
        WebElement madeEasyLink = driver.findElement(By.xpath("/html/body/a"));
        madeEasyLink.click();
        ReusableMethod.beklemeSuresi(3);
    }

}
