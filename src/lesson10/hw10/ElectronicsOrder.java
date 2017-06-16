package lesson10.hw10;

import java.util.Date;

/**
 * Created by user on 09.06.2017.
 */
public class ElectronicsOrder extends Order {

    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipToCity,
                            int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        if((getShipToCity().equals("Киев") || getShipToCity().equals("Одесса") ||
                getShipToCity().equals( "Днепр") || getShipToCity().equals( "Харьков")) &&
                (getCustomerOwned().getCity().equals("Киев") || getCustomerOwned().getCity().equals("Одесса") ||
                 getCustomerOwned().getCity().equals("Днепр")|| getCustomerOwned().getCity().equals("Харьков")) &&
                getBasePrice() >= 100 && getCustomerOwned().getGender().equals("Женский")){
            setDateConfirmed(new Date());
        } else {
            setDateConfirmed(null);
        }
    }

    @Override
   public void calculatePrice() {
        double totalprice;
        if( !(getShipToCity().equals("Киев") ||getShipToCity().equals("Одесса")) ){
            totalprice = getBasePrice() * 1.15;
        } else {
            totalprice = getBasePrice() * 1.1;

        }
        if(getBasePrice() > 1000){
            totalprice = totalprice * 0.95;
        }

        setTotalPrice(totalprice);

    }
}
