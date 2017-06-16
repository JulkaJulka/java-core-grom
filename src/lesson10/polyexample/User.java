package lesson10.polyexample;

/**
 * Created by user on 07.06.2017.
 */
public class User extends Human{

    public User(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("User class is called...");
        super.run();
    }
}
