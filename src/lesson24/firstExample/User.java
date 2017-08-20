package lesson24.firstExample;

/**
 * Created by user on 19.08.2017.
 */
public class User {
    private int age;

    public User(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }
}
