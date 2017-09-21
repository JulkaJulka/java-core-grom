package lesson26;

import java.util.ArrayList;

/**
 * Created by user on 18.09.2017.
 */
public class ArrayListExample {
    public static void main(String[] args) {
        int[] test = new int[5];
        test[0] = 10;
        int[] test1 = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(7);
        System.out.println(list.toString());

        list.remove(0);
        System.out.println(list.toString());

        list.add(11);
        list.add(11);

        System.out.println(list.toString());
        list.add(2,33);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(0);

        list.addAll(list1);

        System.out.println(list);

        list.set(3,5555);
        System.out.println(list);

        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.useList();

    }
}
