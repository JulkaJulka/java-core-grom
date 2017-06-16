package lesson3;

/**
 * Created by user on 15.03.2017.
 */
public class SumAndDivision {
    public static void main(String[] args) {
        

        int sum  = 0;
        int div;
        int rem;
        boolean trueBool = true;

        for (int i = 0 ; i <= 1000 ; i++) {

            sum = sum + i;
        }

        div = sum / 1234;
        rem = sum % 1234;

        System.out.println(sum);
        System.out.println(div);
        System.out.println(rem);

        while (rem > div) {
            System.out.println(trueBool);
            break;
        }
    }
}
