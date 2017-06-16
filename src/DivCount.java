/**
 * Created by user on 24.03.2017.
 */
public class DivCount {

    public static void main(String[] args) {
       System.out.println(findDivCount((short)1,(short)2,1));
        //System.out.println(count((short)-4,(short)-1,1));
        System.out.println(count((short)4,(short)8,1));
    }

    public static int findDivCount(short a, short b, int n) {
        int count = 0;
        for (long i = (int)a; i <= (int)b; i++) {
            if (n > 0 && i % n == 0 && a > 0 && a <= b)
                count++;
        }
            return count;
        }

    public static int count(short a, short b, int n) {
        short count = 0;
        for (short i = a; i <= b; i++) {
            if (i % n == 0)
                count++;
        }
        return (int)count;
    }
}

