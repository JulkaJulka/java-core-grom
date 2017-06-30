package lesson4;

import static lesson4.CompareSum.sum;

/**
 * Created by user on 21.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
        CompareSum compareSum = new CompareSum();

        System.out.println("---Test sum---");
        // max int value
        int a2 = 999999999;
        int b2 = 999999999;
        System.out.println(compareSum.sum(a2, b2));
        // from negotive to positive
        int a1 = -5;
        int b1 = 3;
        System.out.println(compareSum.sum(a1, b1));
        //from = to
        int a = 0;
        int b = 0;
        System.out.println(compareSum.sum(a, b));

        // from > to
        int from = 30;
        int to = 0;
        System.out.println(compareSum.sum(from, to));

        System.out.println("---Test compareSums---");
        //zero,equal sum
        System.out.println(compareSum.compareSums(6, 0, 0, 6));
        //negative
        System.out.println(compareSum.compareSums(-2, 4, -3, -9));
        // max int value
        System.out.println(compareSum.compareSums(999999999, 999999998, 999999999, 999999999));

        DivCount divCount = new DivCount();
        System.out.println("---Test findDivCount---");
        //n ==0
        System.out.println(divCount.findDivCount((short)999999998,(short)999999999,0));
        // b < a
        System.out.println(divCount.findDivCount((short)5,(short)4,2));
        // a < 0
        System.out.println(divCount.findDivCount((short)-2,(short)4,2));

        System.out.println("-----Test count-----");

       //i% n == 0
        System.out.println(divCount.count((short)3,(short)10, 3));
        // b > a
        System.out.println(divCount.count((short)10,(short)4, 3));
        // b = a = 0
        System.out.println(divCount.count((short)0,(short)0, 0));


MethodExample methodExample = new MethodExample();
        System.out.println("---Test increaser---");
        System.out.println(methodExample.increaser(-1,10));
        //max int value
        System.out.println(methodExample.increaser(999999990,999999999));
        //zero
        System.out.println(methodExample.increaser(0,-4));
        System.out.println("---Test min---");

        System.out.println(methodExample.min(0,0));
        //negative
        System.out.println(methodExample.min(-10, -90));
        System.out.println(methodExample.min(-6,100));

        PracticeExample practiceExample = new PracticeExample();
        System.out.println("---Test min a,b,c---");

        System.out.println(practiceExample.min(-90,0,300));
        //equal
        System.out.println(practiceExample.min(-90,-90,-90));
        //zero
        System.out.println(practiceExample.min(0,0,0));

        System.out.println("---Test average---");
        System.out.println(practiceExample.average(78));
        //negative
        System.out.println(practiceExample.average(-100));
        //zero
        System.out.println(practiceExample.average(0));

        //b < a
        System.out.println(practiceExample.average(-10, -15));
//zero
        System.out.println(practiceExample.average(0, 0));
        //









    }


}
