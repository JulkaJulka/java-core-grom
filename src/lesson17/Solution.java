package lesson17;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String str = "df4 44 %kj";
        System.out.println(mostCountedWords(str));
    }

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
        // работающий, но менее читабельный:
        /*  char[] symbals = word.toCharArray();
        int count = 0;
        for (int i = 0; i < symbals.length; i++) {
	            if (Character.isLetter(symbals[i])) {
	                count++;
	            }

	        }
	        if (count == symbals.length)
	            return true;
        return false;
    }*/
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
    public static boolean checkStringWithoutSpecSymbal(String string){
        string.trim();
        String[] str = string.split(" ");
        int countWordWithoutSpecSymbal = 0;
        int count = str.length;
        for (String word: str) {
            if(checkWithoutSpecSymbol(word)){
                countWordWithoutSpecSymbal++;
            }
        }
        if(countWordWithoutSpecSymbal == count)
            return true;
        return false;

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

    public static String mostCountedWords(String input) {
        if (input.length() == 0 || input.equals(null) || input.isEmpty())
            return null;
        input.trim();

        String[] str = input.split(" ");
        if (str.length == 0)
            return null;

        if (str.length == 1 && !checkWithoutSpecSymbol(str[0]))
        {   return null;}

        if(!checkStringWithoutSpecSymbal(input))
            return null;





        int countMax = 0;
        int index1 = 0;

        for (int i = 0; i < str.length; i++) {
            int count1 = 0;

            for (String word : str) {
                if (str[i].equals(word) && checkWithoutSpecSymbol(word)) {
                    count1++;
                } else {
                    count1 = count1;
                }}
                if (count1 > countMax) {
                    countMax = count1;
                    index1 = i;
                 //   System.out.println("MostCount " + countMax);
                 //   System.out.println(index1);

                }
            }

            String mostCountedWord = str[index1];
            return mostCountedWord;
        }





    public static boolean validate(String address) {
        if (address.length() <= 11)
            return false;

        String[] domens = {".org", ".net", ".com"};

        for (String domen : domens) {
            if (address.equals("http://www" + domen) || address.equals("https://www" + domen)) {
                return false;
            }
        }

        String[] protocols = {"http://", "https://", "http://www.", "https://www."};

        for (String protocol : protocols) {
            if (address.substring(0, protocol.length()).equals(protocol) &&
                    validateDomen(address, domens) &&
                    checkWithoutSpecSymbol(address.substring(protocol.length(), address.length() - 4)) == true)
                return true;
        }
        return false;
    }

    public static boolean validateDomen(String address, String[] domens) {
        if (address.equals(null) || address.length() == 0)
            return false;

        if (domens.length == 0)
            return false;

        boolean validateDomen = true;

        for (String domen : domens) {
            if (address.substring(address.length() - domen.length()).equals(domen)) {
                validateDomen = true;
                //System.out.println(validateDomen);
                break;
            }
            validateDomen = false;
        }
        return validateDomen;
    }


}
