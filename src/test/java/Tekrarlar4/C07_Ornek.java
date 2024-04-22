package Tekrarlar4;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C07_Ornek extends TestBase {

    @Test
    public void test(){

        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverKutusu = driver.findElement(By.xpath("//button[text()='Hover Over Me Second!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverKutusu).perform();
        ReusableMethod.beklemeSuresi(3);

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[2]")).click();

        ReusableMethod.beklemeSuresi(2);


        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        ReusableMethod.beklemeSuresi(2);

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        ReusableMethod.beklemeSuresi(2);

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButonu = driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions.sendKeys(clickAndHoldButonu).clickAndHold();
        ReusableMethod.beklemeSuresi(2);

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement kutuTexti = driver.findElement(By.xpath("//div[@id='click-box']"));
        System.out.println(kutuTexti.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement ciftTiklama = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.sendKeys(ciftTiklama).doubleClick();
        ReusableMethod.beklemeSuresi(5);
    }
}
