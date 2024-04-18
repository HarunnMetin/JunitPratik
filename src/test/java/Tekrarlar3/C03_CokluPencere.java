package Tekrarlar3;

import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

import static Utilites.ReusableMethod.beklemeSuresi;

public class C03_CokluPencere extends TestBase {


    @Test
    public void cokluPencere(){

        //amazon anasayfaya gidip url'in amazon icerdigini test edin
        driver.get("https://www.amazon.com");
        beklemeSuresi(2);
        driver.navigate().refresh();
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        String amazonWindowHandleDegeri = driver.getWindowHandle();
        beklemeSuresi(1);

        //yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB).get("https://wisequarter.com");
        String expectedWiseUrl = "wise";
        String actualWiseUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        String wiseWindowHandleDegeri = driver.getWindowHandle();
        beklemeSuresi(2);

        //yeni bir pencerede'da youtube'a gidin ve url'in youtube icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        String expectedYoutubeUrl = "youtube";
        String actualYoutubeUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        beklemeSuresi(2);
        String youtubeWindowHandleDegeri = driver.getWindowHandle();

        //wisequarterin acik oldugu sayfaya donup title'in Wise icerdigini test edin
        driver.switchTo().window(wiseWindowHandleDegeri);
        String expectedWiseTitle = "Wise";
        String actualWiseTitle = driver.getTitle();
        Assert.assertTrue(actualWiseTitle.contains(expectedWiseTitle));
        beklemeSuresi(2);
        //Amazon'un acik oldugu sayfaya donun ve title'in Amazon icerdigini test edin
        driver.switchTo().window(amazonWindowHandleDegeri);
        String expectedAmazonTitle = "Amazon";
        String actualAmazonTitle = driver.getTitle();
        Assert.assertTrue(actualAmazonTitle.contains(expectedAmazonTitle));

    }
}
