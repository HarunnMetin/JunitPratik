package Tekrarlar3;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class C05_Soru extends TestBase {

    @Test
    public void cokluPencere(){

        //● Yeni bir class olusturun: WindowHandle
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        ReusableMethod.beklemeSuresi(2);
        driver.navigate().refresh();

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandleDegeri = driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedAmazonTitle = "Amazon";
        String actualAmazonTitle = driver.getTitle();
        Assert.assertTrue(actualAmazonTitle.contains(expectedAmazonTitle));

        Set<String> window = driver.getWindowHandles();
        for (String each:window) {
            if (!each.contains(actualAmazonTitle)){
                driver.switchTo().window(each);
            }

        }

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        ReusableMethod.beklemeSuresi(2);

        //● Sayfa title’nin “wisequarter” icerdigini test edin
        String expectetWiseTitle = "wisequarter";
        String actualWiseTitle = driver.getTitle();
        Assert.assertTrue(actualWiseTitle.contains(expectetWiseTitle));
        String wiseHandleDegeri = driver.getWindowHandle();

        for (String each:window) {
            if (!each.contains(wiseHandleDegeri)){
                driver.switchTo().window(each);
            }

        }

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");
        ReusableMethod.beklemeSuresi(2);

        //● Sayfa title’nin “Walmart” icerdigini test edin
        String expectedWalmartTitle = "Walmart";
        String actualWalmaerTitle = driver.getTitle();
        Assert.assertTrue(actualWalmaerTitle.contains(expectedWalmartTitle));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    }
}
