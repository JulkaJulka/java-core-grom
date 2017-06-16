package lesson5;

import java.util.Arrays;

/**
 * Created by user on 28.03.2017.
 */
public class UniqueNumberArray {
    public static void main(String[] args) {
        int[] mas = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};
        System.out.println(uniqueCount(mas));
    }

    static int uniqueCount(int[] mas){
        for (int i = 1; i <= mas.length ; i++) {
            for (int j = 0; j <mas.length - 1 ; j++) {
                int a = mas[j];
                int b = mas[j + 1];
                if(b < a){
                    int number1 = b;
                    int number2 = a;
                    mas[j] = b;
                    mas[j + 1] = a;
                }
            }

        }

        //количество повторений
        int count = 0;
        for (int i = 0; i < mas.length-1; i++) {
            if(mas[i] == mas[i + 1]){
                count = count + 1;
            }
        }

        // количество уникальных чисел
        int uniqueCount = mas.length - count;
        return uniqueCount;

    }
}
