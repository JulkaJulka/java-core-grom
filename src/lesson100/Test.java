package lesson100;

import java.util.Arrays;

/**
 * Created by user on 22.09.2017.
 */
public class Test {
    public static void main(String[] args) {
        CompareString compareString = new CompareString();
       System.out.println(compareString.compare("test0", "test0"));

        Integer[] mas1 = {2};
        Integer[] mas2 = {2};
        int[] mas3 = {678,45};
        int[] mas4 = {6,8,0};

        String[] str1 = {"test0"};
        String[] str2 = {"test0", "90"};

       Solution<Integer> solution1 = new Solution<>();
        Solution<String> solution2 = new Solution<>();
        System.out.println(solution2.compareStringArrays(str1, str2));

        System.out.println(solution1.compareArrays(mas1, mas2));

    }
}
