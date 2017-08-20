package lesson23;

/**
 * Created by user on 18.08.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Validator validator = new Validator("User", 5);
        System.out.println(validator.getCheckCount());
    }


}
