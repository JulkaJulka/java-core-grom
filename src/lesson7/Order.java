package lesson7;

import java.util.Date;

/**
 * Created by user on 12.05.2017.
 */

public class Order {
    long id;
    int price;
    Date dateCreated;
    boolean isConfirmed;
    Date dateConfirmed;
    String city;
    String country;
    String type;


    public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }
    void confirmOrder() {
        this.isConfirmed = true;
        this.dateConfirmed = new Date();
    }

    boolean checkPrice() {
        if (this.price > 1000) {
            return true;
        } else {
            return false;
        }
    }

    boolean isValidType() {
        if (this.type.equals("Buy") || this.type.equals("Sale")) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Order order = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        order.confirmOrder();
        order.checkPrice();
        order.isValidType();
        System.out.println(order.checkPrice());
        System.out.println(order.isValidType());

    }

}
