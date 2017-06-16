package lesson10.hw10;

/**
 * Created by user on 10.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Natali", "Киев", "Женский");
        Customer customer2 = new Customer("Joy", "Львов", "Мужской");
        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Julia", null, "Одесса", 150, customer1, 6);
        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("Tolya", null, "Днепр", 300, customer1, 12);

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Boris", null, "Харьков", 50,customer2, "7859" );
        FurnitureOrder furnitureOrder2 = new FurnitureOrder("Tanya", null, "Киев", 150,customer2, "4675" );


        electronicsOrder1.validateOrder();
        electronicsOrder1.calculatePrice();
        electronicsOrder1.confirmShipping();
        electronicsOrder2.validateOrder();
        electronicsOrder2.calculatePrice();
        electronicsOrder2.confirmShipping();


       furnitureOrder1.validateOrder();
        furnitureOrder1.calculatePrice();
        furnitureOrder1.confirmShipping();
        furnitureOrder2.validateOrder();
        furnitureOrder2.calculatePrice();
        furnitureOrder2.confirmShipping();



    }



}
