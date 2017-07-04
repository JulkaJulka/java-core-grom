package lesson17.hw17;

import java.util.Arrays;
public class Solution {

    public static int countWords(String input) {
        String[] str = input.split(" ");
        System.out.println(Arrays.toString(str));

        if (input.length() == 0)
            return 0;

        int countWordsWithoutSpecSymbal = 0;
        for (int i = 0; i < str.length; i++) {
            if (checkWithoutSpecSymbol(str[i]) == true) {
                countWordsWithoutSpecSymbal++;
            }

        }
        return countWordsWithoutSpecSymbal;
    }

    public static boolean checkWithoutSpecSymbol(String word) {
        byte[] symbals = word.getBytes();
        int count = 0;
        for (int i = 0; i < symbals.length; i++) {
            if (symbals[i] >= 65 && symbals[i] <= 90 || (symbals[i] >= 97 && symbals[i] <= 122)) {
                count++;
            }
        }
        if (count == symbals.length)
            return true;
        return false;
    }

}
