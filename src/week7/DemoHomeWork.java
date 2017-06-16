package week7;


import java.util.Date;

/**
 * Created by user on 12.05.2017.
 */
public class DemoHomeWork {


    public Order createOrder() {
        //price = 100, dateCreated = текущая, isConfirmed = false, dateConfirmed = null, city = "Dnepr", country = "Ukraine", type = "Buy"
        //int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type
        Date dateCreated = new Date();
        Date dateConfirmed = null;
        Order order = new Order(100, dateCreated, false, dateConfirmed, "Dnepr", "Ukraine", "Buy");
        return order;

    }

    public Order createOrderAndCallMethods(){
        Order order = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        order.confirmOrder();
        order.checkPrice();
        order.isValidType();
        return order;
    }


}


