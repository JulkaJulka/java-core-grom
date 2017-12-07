package lesson31;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by user on 24.10.2017.
 */
public class Additional {
    public static void main(String[] args) {
        String str = "zajjgakkkkfl";
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (char el : ch){
            characterArrayList.add(el);
        }
       // characterArrayList.sort();
        System.out.println(characterArrayList);
        ArrayList<Integer> countRepeatChars = new ArrayList<>();
       // System.out.println(Arrays.toString(countRepeatChars));
int count = 0;
        int countLast = 1;
        for (int i = 0; i < characterArrayList.size() ; i++) {
            if (i != characterArrayList.size() - 1) {
                if (characterArrayList.get(i).equals(characterArrayList.get(i + 1))) {
                    count++;
                } else {
                    countRepeatChars.add(count);
                    count = 1;
                }
            } else {
                countRepeatChars.add(count++);
            }

        }
        System.out.println(countRepeatChars);
    }

}

