package lesson11.biginterfaceexample;

/**
 * Created by user on 12.06.2017.
 */
public class SimpleReader implements Readable {
    @Override
    public void readFileFromStorage(Storage storage) {
        for (File file: storage.getFiles()) {
            if (file != null) {
                System.out.println(file.getName());
            } else {
                System.out.println(file);
            }
        }
    }
}
