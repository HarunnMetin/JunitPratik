package Tekrarlar4;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C01_ActionsClass extends TestBase {


    Actions actions;
    @Test
    public void actionClass(){

        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        actions = new Actions(driver);
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(ciziliAlan).perform();
        ReusableMethod.beklemeSuresi(3);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedText = "You selected a context menu";
        String actualText = driver.switchTo().alert().getText();
        Assert.assertTrue(actualText.contains(expectedText));

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        ReusableMethod.beklemeSuresi(2);

        //6- Elemental Selenium linkine tiklayalim
        WebElement seleniumLinki = driver.findElement(By.xpath("//a[@target='_blank']"));
        seleniumLinki.click();
        ReusableMethod.beklemeSuresi(2);
        String ikinciSayfaWindowHandleDegeri = "";
        Set<String> windowHandleSeti = driver.getWindowHandles();
        for (String each:windowHandleSeti) {
            if (each.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandleDegeri = each;
            }
        }

        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim

        String expectedYazi2 = "Make sure your code lands";
        String actualYazi2 = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYazi2,actualYazi2);

    }
}
