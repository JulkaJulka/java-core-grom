package lesson18.exercise1;

/**
 * Created by user on 19.07.2017.
 */
public class Task {
    public static void main(String[] args) {
       FileStorage fileStorage = new FileStorage();

        System.out.println("===test1===");
        String[] fileNames = {"test1", "test2"};
        fileStorage.setFiles(fileNames);
        System.out.println("Start printing name...");
        printer(fileStorage);
        System.out.println("Done");


        //Test 2 empty files
        System.out.println("===test2===");

        String[] fileNames2 = {};
        fileStorage.setFiles(fileNames2);

        System.out.println("Start printing name...");
        printer(fileStorage);
        System.out.println("Done");

        //Test 3
        System.out.println("===test3===");

        String[] fileNames3 = {"test1", "test2", "test3", "test4","test5", "test6"};
        fileStorage.setFiles(fileNames3);

        System.out.println("Start printing name...");
        printer(fileStorage);
        System.out.println("Done");
    }

    public static  void printer(Storage storage){
        String[] names = storage.getFiles();

        try {
            System.out.println("5th name is " + names[4]);
        } catch (Exception e){
            System.out.println("5th name can not be found...");
           // System.err.println(e.getMessage());
        }
        //Solution
        //hw

    }
}
