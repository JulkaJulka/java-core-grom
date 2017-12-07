package lesson32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by user on 31.10.2017.
 */
public class ReadFromKeyboard {
    public static void main(String[] args) throws IOException {
        //readKeyboardWithScanner();
        readKeyboardWithIOStream();
    }

    private static void readKeyboardWithScanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name");
        String name = scanner.nextLine();
        if (checkName(name))
            System.out.println("Hello, " + name + "!");
        scanner.close();

    }

    private static void readKeyboardWithIOStream() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name");
        String name = br.readLine();
        if (checkName(name))
            System.out.println("Hello, " + name + "!");
    }

    private static boolean checkName(String word) {
        String word1 = word.trim();
        if (word1.length() == 0) {
            System.out.println("You haven't entered name yet");
            return false;
        }
        char[] chars = word1.toCharArray();
        for (char ch : chars) {
            if (!(Character.isLetter(ch))) {
                System.out.println("You entered wrong name");
                return false;
            }
        }
        return true;
    }
}
