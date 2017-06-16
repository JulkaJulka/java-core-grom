package lesson11.firstinterface;

/**
 * Created by user on 12.06.2017.
 */
public class TestClass implements FirstInterface {
    private int test = 10;

    @Override
    public void send() {
        //some logic
    }

    @Override
    public String receive() {
        //some logic
        return null;
    }
}
