package lesson22.hw22;

/**
 * Created by user on 07.08.2017.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        int a = 10;
        if (a > 5)
            throw new BadRequestException("error");
    }
}
