package lesson4;

/**
 * Created by user on 27.03.2017.
 */
public class CompareSum {
    public static void main(String[] args) {
       // System.out.println(sum(3,7));
        System.out.println(compareSums(2,6,2,6));

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
