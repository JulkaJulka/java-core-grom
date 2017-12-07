package lesson33;

import org.apache.commons.io.IOUtils;

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
    private static void readKeyboardWithIOStream() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name");
        try {
            String name = br.readLine();
            if (checkName(name))
                System.out.println("Hello, " + name + "!");

        } catch (IOException e) {
            System.err.println("Reading from keyboard faild");
        } finally {
            try {
                reader.close();
                br.close();
            } catch (IOException e) {
                System.err.println("Closing streams failed");
            }

        }


    }

    private static void readKeyboardWithIOStream2() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name");
        try {
            String name = br.readLine();
            if (checkName(name))
                System.out.println("Hello, " + name + "!");

        } catch (IOException e) {
            System.err.println("Reading from keyboard faild");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }


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
