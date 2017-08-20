package lesson24.firstExample;

/**
 * Created by user on 19.08.2017.
 */
public class Main {

    public static void demo(){

        User user = new User(11);
        Solution solution = new Solution("test1");

        //Demo demo = new Demo();

        Demo<User> demo = new Demo<>();
        demo.print(user);

        Demo<Solution> demo1 = new Demo<>();
        demo1.print(solution);

    }

    public static void main(String[] args) {
        demo();
    }
}
