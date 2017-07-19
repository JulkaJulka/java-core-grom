package lesson18;

/**
 * Created by user on 19.07.2017.
 */
public class ArrayException {
    public static void main(String[] args) {

        int[] array = {1, 0, 5};

        //обработка ошибки
        try {
            System.out.println(array[3]);
        } catch (Exception e) {
            System.err.println("element was not found");
        }
        System.out.println("Cool.... ");
        System.out.println("Cool2.... ");
}
}
