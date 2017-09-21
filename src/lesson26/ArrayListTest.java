package lesson26;

import java.util.*;

/**
 * Created by user on 16.09.2017.
 */
public class ArrayListTest {
    public void useList() {
        Order order1 = new Order(1001, 50, "USD", "ball", "a1@kyiv");
        Order order2 = new Order(1004, 50, "EUR", "bus", "a1@kyiv");
        Order order3 = new Order(1005, 100, "EUR", "bus", "a1@kyiv");
        Order order4 = new Order(1006, 200, "UAH", "bus", "a1@kyiv");
        Order order5 = new Order(1007, 768, "EUR", "bus", "a1@kyiv");
        Order order6 = new Order(1008, 50, "UAH", "bus", "a1@kyiv");
        Order order7 = new Order(1009, 145, "EUR", "bus", "a1@kyiv");
        Order order8 = new Order(1010, 364, "EUR", "bus", "a1@kyiv");

        ArrayList<Order> arrayList = new ArrayList<>();

        arrayList.add(order1);
        arrayList.add(order3);
        arrayList.add(order4);
        arrayList.add(order5);
        arrayList.add(1, order2);
        arrayList.remove(4);
        arrayList.remove(order1);

        Collections.addAll(arrayList, order6, order7);
        System.out.println(arrayList);
        System.out.println(arrayList.subList(1, 4));

        System.out.println(arrayList.set(2, order8));
        System.out.println("contains");
        System.out.println(arrayList.contains(order4));
        arrayList.toArray();
        arrayList.clear();
    }
}
