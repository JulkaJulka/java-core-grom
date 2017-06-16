package lesson8.phones;

/**
 * Created by user on 16.05.2017.
 */
public class IPhone extends Phone {
    boolean fingerPrint;

    public IPhone(int price, double weight, String countryProduced, boolean fingerPrint) {
        super(price,weight,countryProduced);
        this.fingerPrint = fingerPrint;
        System.out.println("IPhone constructor was invoked...");
    }

    void deleteIPhonefromDB(){
        //some logic
        System.out.println("deleteIPhonefromDB invoked...");

    }
}
