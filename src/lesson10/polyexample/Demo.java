package lesson10.polyexample;

/**
 * Created by user on 07.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
Human human = new Human("Test");
        run(human);
        System.out.println();

        User user = new User("Jack");
        user.run();
    }
    public static void run (Human human){
        human.run();

    }
}
