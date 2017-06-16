package lesson3;

/**
 * Created by user on 15.03.2017.
 */
public class LogicalOperator2 {
    public static void main(String[] args) {
        int test1 = 1000;
        boolean result = false;
        if(test1 > 1000){
            result = true;
        }
         if(result)
             System.out.println("Nice");
        else
             System.out.println("Not Nice");
        if(result && test1 >100 && test1 > 500) {
            System.out.println("!");
        }
        else {
            System.out.println("?");
        }




    }
}
