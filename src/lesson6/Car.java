package lesson6;

/**
 * Created by user on 03.05.2017.
 */
public class Car {

    //1Fields

    int price;
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;
    //  ......

    //2 Constructor
    public Car(int price, int yearOfManufacturing, String ownerName) {
        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
        this.ownerName = ownerName;
    }
    //3Mrthods;

    void startRun() {
        System.out.println("I am running....");
    }

    void stopRun() {
        System.out.println("I am stopping....");
    }

    void changeOwner(String newOwnerName) {
        ownerName = newOwnerName;
    }

}
