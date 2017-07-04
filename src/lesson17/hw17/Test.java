package lesson17.hw17;

import java.util.Arrays;

import static lesson17.hw17.Solution.countWords;
public class Test {
    public static void main(String[] args) {
        int[] mas = {12, 3, 5, 87, 32, 100};
        //int[] res = new int[mas.length];

        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            if ((mas[i] > 10 && mas[i] < 15) || (mas[i] > 50 && mas[i] < 100))
                count++;
        }
        System.out.println(count);

        int[] res = new int[count];
        int index = 0;
        for (int i = 0; i < mas.length; i++) {
            if ((mas[i] > 10 && mas[i] < 15) || (mas[i] > 50 && mas[i] < 100)) {
                res[index] = mas[i];
                index++;
            }

        }
        System.out.println(Arrays.toString(res));

        String str = "(fghjsFDDDL #hf0 dfgsQ jhjfhk jfjh %";
        String str1 = "";
        System.out.println(countWords(str));

        //  String word = "ABAgN2MZz";
        //  System.out.println(checkWithoutSpecSymbol(word));

    }

}
