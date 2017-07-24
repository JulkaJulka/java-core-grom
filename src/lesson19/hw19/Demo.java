package lesson19.hw19;

import java.util.Arrays;

/**
 * Created by user on 21.07.2017.
 */
public class Demo {
    public static void main(String[] args) {
File file1 = new File(23, "name1", "jpg", 100 );
        File[] files = {file1, null};
        Storage storage1 = new Storage(234,files, 1000);
        Storage[] storages = {storage1,null};
        Controller controller = new Controller(storages);
        System.out.println(controller.findById(storage1,28));

    }
}
