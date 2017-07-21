package lesson19;

import lesson8.arithmetic.Arithmetic;

import java.util.Objects;

/**
 * Created by user on 21.07.2017.
 */
public class RuntimeExceptionExample {
    public static void main(String[] args) {
        //arithmetic exception(2)
        arithmeticException(2);
        //
        try {
            arithmeticException(0);
        } catch (ArithmeticException e) {
            System.out.println("something wrong");
        }

        npe(new Object());
        //npe(null);


    }

    public static void arithmeticException(int a) {
        System.out.println(10 / a);
    }

    private static void npe(Object object) {
//try{
//    System.out.println(object.hashCode());
//}catch (NullPointerException e){
//    System.out.println();
//}

        if (object != null) {
            System.out.println(object.hashCode());
        }
    }

}
