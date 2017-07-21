package lesson18.hw18;

import java.util.Arrays;

/**
 * Created by user on 20.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String text = "ert 9 1 @345";
        //findNumbers(text);
        System.out.println(Arrays.toString(findNumbers(text)));
    }

    public  static int[] findNumbers(String text) {
        String[] str = text.split(" ");

            int count = 0;
            for (String word : str) {
                if (checkDigits(word)) {
                    count++;
                }
            }
            int[] findNumbers = new int[count];
            int index = 0;

            for (String word : str) {
                try {

                        findNumbers[index] = Integer.parseInt(word);
                        index++;

                } catch (Exception e){
                    System.err.println("not a number");
                }

            }

            return findNumbers;



    }
    public  static int[] findNumbers1(String text) {
        String[] str = text.split(" ");

        int count = 0;
        for (String word : str) {
            if (checkDigits(word)) {
                count++;
            }
        }
        int[] findNumbers = new int[count];
        int index = 0;

        for (String word : str) {
                if (checkDigits(word)) {
                    findNumbers[index] = Integer.parseInt(word);
                    index++;
                } else {
                    System.out.println("not a number");
                }
        }
        return findNumbers;
    }

    public static boolean checkDigits(String word){
        if(word.isEmpty())
            return false;
        char[]  chars = word.toCharArray();
        for (char ch: chars) {
            if(!Character.isDigit(ch))
            return false;
        }
        return true;
    }
}
