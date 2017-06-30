package lesson15.cast;

/**
 * Created by user on 28.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
        InternetProvider provider = (InternetProvider) test();
        FoodProvider foodProvider = (FoodProvider) testFood();
        System.out.println(provider);
    }
   private static  Provider test(){
        //logic
        return new InternetProvider();
    }

   private static  Provider testFood(){
        //logic
        return new InternetProvider();
    }

}
