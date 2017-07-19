package lesson17.hw17;

import java.util.Arrays;

/**
 * Created by user on 12.07.2017.
 */
public class Solution1 {
    public static int countWords(String input) {
        String[] str = input.split(" ");

        if (input.length() == 0)
            return 0;
        if (str.length == 0)
            return 0;

        int countWordsWithoutSpecSymbal = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > 0 && checkWithoutSpecSymbol(str[i]) == true) {
                countWordsWithoutSpecSymbal++;
            }
        }
        return countWordsWithoutSpecSymbal;
    }

    public static boolean checkWithoutSpecSymbol(String word) {
        if (word.isEmpty())
            return false;
        char[] symbals = word.toCharArray();
        for (char c : symbals) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkWordOnLettersDigits(String word) {
        if (word.isEmpty())
            return false;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                return false;
            }
        }
        return true;
    }

    public static String maxWord(String string) {
        if (string.length() == 0)
            return null;
        String[] str = string.split(" ");
        if (str.length == 0)
            return null;

        String maxWord = "";
        for (int i = 0; i < str.length; i++) {
            if (checkWithoutSpecSymbol(str[i]) == true) {
                maxWord = str[i];
                //System.out.println(maxWord);
                break;
            }
        }
        if (maxWord == "")
            return null;
        int max = maxWord.length();
        for (String word : str) {
            if (word.length() > 0 && checkWithoutSpecSymbol(word) == true && word.length() >= max)
                maxWord = word;
        }
        System.out.println(maxWord);
        return maxWord;
    }

    public static String minWord(String string) {
        if (string.length() == 0)
            return null;
        String[] str = string.split(" ");
        if (str.length == 0)
            return null;

        String minWord = "";

        for (int i = 0; i < str.length; i++) {
            if (checkWithoutSpecSymbol(str[i]) == true) {
                minWord = str[i];
                //  System.out.println(minWord);
                break;
            }
        }
        if (minWord == "")
            return null;

        int min = minWord.length();
        for (String word : str) {
            if (word.length() > 0 && checkWithoutSpecSymbol(word) == true && word.length() <= min) {
                minWord = word;
            }
        }
        // System.out.println(minWord);
        return minWord;
    }

    /*public static String mostCountedWords(String string) {
        if (string.length() == 0 || string == null)
            return null;

        String[] str = string.split(" ");

        String word = "";
        int[] res = new int[0];
        int count1 = 0;

        for (int i = 1; i < str.length; i++) {
            for (int j = 0; j < str.length - 1; j++) {
                String a = str[j];
                String b = str[j + 1];
                if (a.equals(b)) {
                    count1++;

                }
            }
        }

        //количество повторений
        int count = 0;
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i].equals(str[i + 1])) {
                count++;
            }
            //System.out.println(count);
        }
        System.out.println(count);
        return null;
    }*/

    public static String mostCountedWords1(String string) {
        if (string.length() == 0)
            return null;
        String[] str = string.split(" ");
        int countUniqWords = 0;
        for (int i = 1; i < str.length; i++) {
            for (String word : str) {
                if (checkWithoutSpecSymbol(word) == true && word.equals(str[i])) {
                    countUniqWords++;
                }
            }
        }
        return null;
    }

    public static boolean validate(String address) {
        if (address.length() == 0 || address.equals(null))
            return false;
        if (validateProtocols(address) && validateDomen(address) && validateName(address))
            return true;
        return false;

    }

    public static boolean validateProtocols(String address) {
        String[] protocols = {"http://", "https://", "http://www.", "https://www."};
        for (String protocol : protocols) {
            if (address.startsWith(protocol))
                return true;


        }
        return false;
    }

    public static boolean validateDomen(String address) {
        String[] domens = {".org", ".net", ".com"};
        for (String domen : domens) {
            if (address.endsWith(domen))
                return true;
        }
        return false;
    }

    public static boolean validateName(String address) {

        String nameAddress = "";
        if (address.contains("www.")) {
            nameAddress = address.substring(address.indexOf('.') + 1, address.lastIndexOf('.'));
            if (checkWordOnLettersDigits(nameAddress))
                return true;
        } else if (address.contains("//")) {
            nameAddress = address.substring(address.lastIndexOf('/') + 1, address.lastIndexOf('.'));
            if (checkWordOnLettersDigits(nameAddress))
                return true;
        }
        return false;
    }

    public static int[] sortString(String str) {
        String[] words = str.split(" ");
        // System.out.println(words);
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                String a = words[j];
                String b = words[j + 1];
                if (a.compareTo(b) > 0) {
                    String word1 = a;
                    String word2 = b;
                    words[j] = b;
                    words[j + 1] = a;
                }
            }
        }
        System.out.println(Arrays.toString(words));
        // количество повторений
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals(words[i + 1]))
                count++;

        }
        System.out.println(count);
        // количество уникальных слов
        int wordsUniq = words.length - count;
        System.out.println(wordsUniq);

        int[] res = new int[wordsUniq];
        int countRepeatWord = 1;
        int k = 0;
       /* for (int i = 0; i < words.length ; i++) {
            if(words[i].equals(words[i + 1]))*/

        return res;
    }


}
