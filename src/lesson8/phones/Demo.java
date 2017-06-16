package lesson8.phones;

/**
 * Created by user on 16.05.2017.
 */
public class Demo {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone(110, 10.0, "Chine", true);

        iPhone.deleteIPhonefromDB();
        iPhone.orderPhone();
    }
}
