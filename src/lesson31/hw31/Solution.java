package lesson31.hw31;

import java.util.*;

/**
 * Created by user on 21.10.2017.
 */
public class Solution {

    public Map<Character, Integer> countSymbols(String text) {
        char[] chars = text.toCharArray();
        // Arrays.sort(chars);

        ArrayList<Character> charsList = new ArrayList<>();
        for (Character ch : chars) {
            if (Character.isLetter(ch)) {
                charsList.add(ch);
            }
        }

        Map<Character, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < charsList.size(); i++) {

            if (!treeMap.containsKey(charsList.get(i))) {
                treeMap.put(charsList.get(i), 1);
            } else {
                treeMap.replace(charsList.get(i), treeMap.get(charsList.get(i)) + 1);
            }
        }
        //  System.out.println("treeMap : " + treeMap);
        return treeMap;
    }

    public Map words(String text) {
        String[] str = text.split(" ");
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (String el : str) {
            if(checkWordOnLetters(el)){
                stringArrayList.add(el);
            }
        }

        Map<String, Integer> treeMap = new TreeMap<>();

        int index = 0;
        for (String word : stringArrayList){
            if(!treeMap.containsKey(word)){
                treeMap.put(word,1);
            } else {
                treeMap.replace(word,treeMap.get(word) + 1);

            }
            index++;
        }

        return treeMap;
    }

    public boolean checkWordOnLetters(String word) {
        int lengthOfword = 2;
        if (word.length() <= lengthOfword)
            return false;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch)) {
                return false;
            }

        }
        return true;
    }


}
