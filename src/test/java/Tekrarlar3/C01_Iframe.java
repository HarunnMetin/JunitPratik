package Tekrarlar3;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C01_Iframe extends TestBase {

    @Test
    public void frameTesti(){

        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        ReusableMethod.beklemeSuresi(3);
        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.
        WebElement iframeTexti = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        System.out.println(iframeTexti.getText());
        Assert.assertTrue(iframeTexti.isEnabled());
        ReusableMethod.beklemeSuresi(2);
        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        WebElement aramaKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Merhaba Dunya!"+ Keys.ENTER);
        ReusableMethod.beklemeSuresi(3);

        driver.switchTo().defaultContent();
        ReusableMethod.beklemeSuresi(1);



        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.
        WebElement selniumTexti = driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(selniumTexti.getText());
        Assert.assertTrue(selniumTexti.isDisplayed());
    }
}
