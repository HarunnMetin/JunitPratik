package Tekrarlar4;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C08_Ornek extends TestBase {

    @Test
    public void test(){

        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        WebElement videoKonumu = driver.findElement(By.xpath("(//div[@class='render'])[1]"));
        actions.sendKeys(Keys.END).sendKeys(videoKonumu);
        ReusableMethod.beklemeSuresi(3);

        //4- videoyu izlemek icin Play tusuna basin

        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        WebElement videoPlay = driver.findElement(By.xpath("//button[@title='Oynat']"));
        videoPlay.click();
        WebElement genisEkran = driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));

        genisEkran.click();

        ReusableMethod.beklemeSuresi(20);
        //5- videoyu calistirdiginizi test edin
        WebElement playControl = driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        Assert.assertTrue(playControl.isEnabled());
    }
}
