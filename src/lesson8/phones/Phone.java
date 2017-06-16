package lesson8.phones;

/**
 * Created by user on 16.05.2017.
 */
public class Phone {
    int price;
    double weight;
    String countryProduced;

    public Phone(int price, double weight, String countryProduced) {
        this.price = price;
        this.weight = weight;
        this.countryProduced = countryProduced;
        System.out.println("Phone constructor was invoked...");
    }

    void orderPhone(){
        System.out.println("order phone invoked...");

    }
}
