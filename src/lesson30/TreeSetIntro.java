package lesson30;

import lesson29.File;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by user on 02.10.2017.
 */
public class TreeSetIntro {
    public static void main(String[] args) {
        Set<File> files = new TreeSet<>();

        File file1 = new File("pict.txt", 100);
        File file2 = new File("home.txt", 178);
        File file3 = new File("home555.txt", 340);
        files.add(file1);
        files.add(file2);
        files.add(file3);
        System.out.println(files);
    }
}
