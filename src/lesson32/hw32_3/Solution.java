package lesson32.hw32_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by user on 07.11.2017.
 */
public class Solution {
    public void readNumbers() throws Exception {
        int sum = 0;
        int n = 3;
        while (n <= 3 && n >= 0) {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(reader);

            String values = br.readLine();
            String[] stringNumber = values.split(" ");
            if (n == 0) {
                System.out.println("Your numbers are wrong. Number of attempts exceeded");
                break;
            }
            if (!validationNumbers(stringNumber)) {
                System.out.println("Your numbers are wrong. You have " + n + " attempts to try again");
                n--;
            } else {
                for (String el : stringNumber) {
                    int number = Integer.parseInt(el);
                    sum += number;
                }
                System.out.println(sum);
            }
        }
    }

    public boolean checkNumber(String word) {
        if (word.length() == 0)
            return false;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public boolean validationNumbers(String[] words) {
        if (words.length != 10)
            return false;
        for (String el : words) {
            if (el.length() == 0)
                return false;
        }
        for (String word : words) {
            if (!(checkNumber(word) && Integer.parseInt(word) <= 100)) {
                return false;
            }
        }
        return true;
    }
}
