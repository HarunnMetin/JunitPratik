package Tekrarlar4;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_DragAndDrop extends TestBase {

    Actions actions;
    @Test
    public void dragAndDrop(){

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        ReusableMethod.beklemeSuresi(2);

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragMe = driver.findElement(By.xpath("(//div[@class='drag-box mt-4 ui-draggable ui-draggable-handle'])[1]"));
        WebElement dropHere = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions = new Actions(driver);
        actions.dragAndDrop(dragMe,dropHere).perform();
        ReusableMethod.beklemeSuresi(2);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement dropped = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedYazi = "Dropped!";
        String actualYazi = dropped.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
