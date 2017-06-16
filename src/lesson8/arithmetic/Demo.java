package lesson8.arithmetic;

/**
 * Created by user on 18.05.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Adder adder = new Adder();
        adder.add(5, 6);
        System.out.println(adder.add(5, 6));

        int[] mas = {50, 43, 65, 2, 0, 91};
        adder.check(mas);
        System.out.println(adder.check(mas));

    }
}
