package lesson8.phones;

/**
 * Created by user on 16.05.2017.
 */
public class Android extends Phone{

    String androidVersion;
    int screenSize;

    String secretDeviseCode;

    public Android(int price, double weight, String countryProduced, String androidVersion, int screenSize, String secretDeviseCode) {
        //this.price = price;
        //this.weight = weight;
       // this.countryProduced = countryProduced;

        // this - reference to the current object class;
        // super - reference to the parrent class
        super(price,weight,countryProduced);
        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviseCode = secretDeviseCode;
    }

    void installNewAndroidVersion(){
       //some logic
        System.out.println("installNewAndroidVersion invoked...");
    }
}
