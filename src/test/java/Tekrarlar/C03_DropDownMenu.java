package Tekrarlar;

import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Utilites.ReusableMethod.beklemeSuresi;

public class C03_DropDownMenu extends TestBase {

    @Test
    public void dropDownTesti(){

        //● Bir class oluşturun: DropDown
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDownElemnti = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDownElemnti);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        beklemeSuresi(2);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        beklemeSuresi(2);
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        beklemeSuresi(2);
        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> dropDownList = select.getOptions();
        int sayi =1;
        for (WebElement each:dropDownList) {
            System.out.println(sayi+ " - "+each.getText());
            sayi++;
        }
        //5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedBoyut = 4;
        int actualBoyut = dropDownList.size();
        Assert.assertTrue("buyut 4 den buyuk degil",actualBoyut == expectedBoyut);

    }

}
