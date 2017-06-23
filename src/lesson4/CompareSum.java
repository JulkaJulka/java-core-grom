package lesson4;

/**
 * Created by user on 27.03.2017.
 */
public class CompareSum {
    public static void main(String[] args) {
       // System.out.println(sum(3,7));
        System.out.println(compareSums(2,6,2,6));

        // from > to
        int from = 30;
        int to = 0;
        System.out.println(sum(from, to));
        //from = to
        int a = 0;
        int b = 0;
        System.out.println(sum(a, b));
// from negotive to positive
        int a1 = -5;
        int b1 = 3;
        System.out.println(sum(a1, b1));
        // max int value
        int a2 = 567485747;
        int b2 = 999999999;
        System.out.println(sum(a2, b2));
    }

    public static long sum(int from, int to){
        long sum = 0;
        for (long i = from; i <= to; i++) {
            sum += i;
        }
        return sum;
    }

    public static boolean compareSums(int a, int b, int c, int d){
        long sum1 = sum(a, b);
        long sum2 = sum(c,d);
        boolean compare = true;
      if (sum2 >= sum1) {
          compare = false;
      }
      return compare;
    }
}
