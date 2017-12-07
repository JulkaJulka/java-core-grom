package lesson33;

/**
 * Created by user on 09.11.2017.
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.readFile("C:/Users/user/Desktop/testsub");
       readWriteFile.writeFile("C:/Users/user/Desktop/testsub", "SAVE in new line");
        readWriteFile.readFile("C:/Users/user/Desktop/testsub");
    }
}
