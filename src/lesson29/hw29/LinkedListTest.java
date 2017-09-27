package lesson29.hw29;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by user on 25.09.2017.
 */
public class LinkedListTest {

    public HashSet useHAshList() {
        Order order1 = new Order(1001, 50, "USD", "ball", "a1@kyiv");
        Order order2 = new Order(1004, 50, "EUR", "bus", "a1@kyiv");
        Order order3 = new Order(1005, 100, "EUR", "bus", "a1@kyiv");
        Order order4 = new Order(1006, 200, "UAH", "bus", "a1@kyiv");
        Order order5 = new Order(1007, 768, "EUR", "bus", "a1@kyiv");
        Order order6 = new Order(1008, 50, "UAH", "bus", "a1@kyiv");
        Order order7 = new Order(1009, 145, "EUR", "bus", "a1@kyiv");
        Order order8 = new Order(1010, 364, "EUR", "bus", "a1@kyiv");
        Order order9 = new Order(2000, 364, "EUR", "bus", "a1@kyiv");
        HashSet<Order> hashSet = new HashSet<>();
        hashSet.add(order1);
        hashSet.add(order2);
        hashSet.add(order3);
        hashSet.add(order5);
        hashSet.add(order4);
        hashSet.add(order8);
        hashSet.add(order7);
        hashSet.add(order6);

        HashSet<Order> hashSet2 = new HashSet<>();
        hashSet2.add(order5);
        hashSet2.add(order4);
        hashSet2.add(order8);
        hashSet2.add(order7);
        hashSet2.add(order6);
        hashSet2.add(order9);


        hashSet.remove(order2);
        hashSet.retainAll(hashSet2);
        hashSet.toArray();
        hashSet.size();

        Iterator<Order> iterator = hashSet2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getId());
        }

        return hashSet;

    }
}
