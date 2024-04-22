package Tekrarlar4;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_MoveToElement extends TestBase {

    Actions actions;
    @Test
    public void moveToElement(){


        //Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        ReusableMethod.beklemeSuresi(2);
        driver.navigate().refresh();

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement accountListMenusu = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions = new Actions(driver);
        actions.moveToElement(accountListMenusu).perform();
        ReusableMethod.beklemeSuresi(2);

        //3- “Create a list” butonuna basin
        WebElement createList = driver.findElement(By.xpath("//span[text()='Create a List']"));
        createList.click();
        ReusableMethod.beklemeSuresi(2);

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement sayfaYazisi = driver.findElement(By.xpath("//div[@role='heading']"));
        String expectedYazi = "Your Lists";
        String actualYazi = sayfaYazisi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
