package lesson10.hw10;

import java.util.Date;

/**
 * Created by user on 10.06.2017.
 */
public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipToCity, int basePrice,
                          Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
      public void validateOrder() {
        if((getCustomerOwned().getCity().equals("Киев") || getCustomerOwned().getCity().equals("Львов"))
                && getBasePrice() >= 500 && !(getCustomerOwned().getName().equals("Тест"))
                && (getCustomerOwned().getGender().equals("Мужской") ||
                getCustomerOwned().getGender().equals("Женский"))){
            setDateConfirmed(new Date());
        } else {
            setDateConfirmed(null);
        }
    }

    @Override
    public void calculatePrice() {
        double totalPrice;
        if(getBasePrice() < 5000){
            totalPrice = getBasePrice() * 1.05;
        } else {
            totalPrice = getBasePrice() * 1.02;
        }
        setTotalPrice(totalPrice);

    }
}
