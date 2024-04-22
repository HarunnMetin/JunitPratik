package Tekrarlar4;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import net.bytebuddy.implementation.bytecode.ShiftLeft;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_KeyboardActions extends TestBase {

    @Test
    public void keyboardActions(){

        //1- Bir Class olusturalim KeyboardActions1
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        ReusableMethod.beklemeSuresi(2);
        driver.navigate().refresh();

        //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung")
                .keyDown(Keys.SPACE)
                .keyUp(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .perform();
        ReusableMethod.beklemeSuresi(3);

        //Enter’a basarak arama yaptirin
        aramaKutusu.sendKeys(Keys.ENTER);

        //4- aramanin gerceklestigini test edin
        WebElement aramaControl = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String expectedIcerik = "Samsung A71";
        String actualIcerik = aramaControl.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }
}
