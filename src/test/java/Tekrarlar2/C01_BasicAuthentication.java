package Tekrarlar2;

import Utilites.ReusableMethod;
import Utilites.TestBase;
import org.junit.Test;

public class C01_BasicAuthentication extends TestBase {

    @Test
    public void basicauthentication(){

        //1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth
        //sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak
        //authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username : admin
        //password : admin
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        String username = "admin";
        String password = "admin";
        String url = "https//:"+username+":"+password+"@the-internet.herokuapp.com/basic_auth";
        driver.get(url);
        ReusableMethod.beklemeSuresi(3);


    }


}
