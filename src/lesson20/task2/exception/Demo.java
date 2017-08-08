package lesson20.task2.exception;

import lesson20.task2.Controller;

/**
 * Created by user on 07.08.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();
        String city = "";
        System.out.println(controller.cityAllowed(city));
    }
}
