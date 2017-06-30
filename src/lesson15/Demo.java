package lesson15;

import lesson11.biginterfaceexample.*;
import lesson15.cast.User;
public class Demo {
    public static void main(String[] args) {
        File file1 = new File(1001, "home/Documents/test", "txt");
        File file2 = new File(1001, "home/Documents/image", "img");
        File file3 = new File(1001, "home/Documents/test", "txt");

        File someFile = file1;

        System.out.println(file1.equals(file2));
        System.out.println(file1.hashCode());
        System.out.println(file2.hashCode());
        System.out.println(file1.equals(file3));
        System.out.println(file1 == file3);

        System.out.println(file1 == someFile);
        User user = new User(1001);
        System.out.println(file1.equals(user));
    }
}
