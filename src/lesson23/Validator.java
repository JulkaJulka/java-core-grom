package lesson23;

/**
 * Created by user on 18.08.2017.
 */
public class Validator {
    private String name;
    private final int checkCount;

    public Validator(String name, int checkCount) {
        this.name = name;
        this.checkCount = checkCount;
    }

    public String getName() {
        return name;
    }

    public int getCheckCount() {
        return checkCount;
    }
}
