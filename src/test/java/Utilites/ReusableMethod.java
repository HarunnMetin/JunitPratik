package Utilites;

public class ReusableMethod {

    public static void beklemeSuresi(int saniye){

        try {
            Thread.sleep(saniye*1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
