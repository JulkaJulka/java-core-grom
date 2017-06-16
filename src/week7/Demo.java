package week7;

import week6.Car;
import week6.DbConnector;
import week6.User;

/**
 * Created by user on 12.05.2017.
 */
public class Demo {
    public static void main(String[] args) {
        // className(type) objectName = new className();
        // className(type) objectName = new className(atributes);

        User user = new User();
        User user1 = new User();
        User user2 = new User();

        User user3 = new User("Jack");
        Car car = new Car(10000, 2015, "Anton");
        // Car car = new Car();

        DbConnector dbConnector = new DbConnector();


    }
}
