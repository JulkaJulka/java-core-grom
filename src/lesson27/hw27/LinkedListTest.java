package lesson27.hw27;
import java.util.*;

/**
 * Created by user on 18.09.2017.
 */
public class LinkedListTest {

    public void useList(){

        Order order1 = new Order(1001, 50, "USD", "ball", "a1@kyiv");
        Order order2 = new Order(1004, 50, "EUR", "bus", "a1@kyiv");
        Order order3 = new Order(1005, 100, "EUR", "bus", "a1@kyiv");
        Order order4 = new Order(1006, 200, "UAH", "bus", "a1@kyiv");
        Order order5 = new Order(1007, 768, "EUR", "bus", "a1@kyiv");
        Order order6 = new Order(1008, 50, "UAH", "bus", "a1@kyiv");
        Order order7 = new Order(1009, 145, "EUR", "bus", "a1@kyiv");
        Order order8 = new Order(1010, 364, "EUR", "bus", "a1@kyiv");


        LinkedList<Order> linkedList = new LinkedList<>();


        linkedList.add(order1);
        linkedList.add(order3);
        linkedList.add(order4);
        linkedList.add(order5);
        linkedList.add(1, order2);
        System.out.println(linkedList.remove(4));
        System.out.println(linkedList.remove(order1));

        Collection collection = new ArrayList<Order>();
        collection.add(order6);
        collection.add(order7);

        linkedList.addAll(2, collection);
        System.out.println(linkedList);
        System.out.println(linkedList.subList(1, 4));

        System.out.println(linkedList.set(2, order8));
        System.out.println(linkedList.contains(order4));
        System.out.println(linkedList.toArray());
        linkedList.clear();
    }
}
