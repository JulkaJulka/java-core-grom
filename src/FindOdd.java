/**
 * Created by user on 15.03.2017.
 */
public class FindOdd {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 1000 ; i++) {
            if (i % 2 != 0){
                System.out.println("Found");
                sum += i;
            }


        }
        int mul = sum *5;

        if(mul > 5000){
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller or equal");
        }
    }
}
