package Tekrarlar;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import Utilites.TestBaseBeforClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class C04_DropDownMenu extends TestBase {

    WebElement amazonDropDownMenu;
    Select select;
    @Before
    public void amazonaGidis(){

        // https://www.amazon.com/ adresine gidin.

        driver.get("https://www.amazon.com");
        ReusableMethod.beklemeSuresi(3);
        driver.navigate().refresh();
        WebElement amazonDropDownMenu = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        select = new Select(amazonDropDownMenu);
    }
    @Test
    public void dropDownTesti(){

        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 old test edin
        List<WebElement> kategoriList = select.getOptions();
        int actualKategoriSayisi = kategoriList.size();
        Assert.assertEquals(45,actualKategoriSayisi);
    }
    @Test
    public void booksKategoriSecimi(){

        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");
        //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());
        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedYazi = "Java";
        String actualYazi = sonucSayisi.getText();
        Assert.assertTrue(actualYazi.contains(expectedYazi));
    }
}
