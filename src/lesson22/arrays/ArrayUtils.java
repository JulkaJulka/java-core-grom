package lesson22.arrays;

/**
 * Created by user on 17.08.2017.
 */
public class ArrayUtils {


    public static int maxElement(int[] mas){
        int max = mas[0];
        for (int el : mas) {
            if(el > max)
                max = el;
        }
        return max;
    }

    public static int nCount(int[] mas, int n){
        int count = 0;

        for (int el : mas){
            if(el == n)
                count++;
        }
        return count;

    }

    public static int[]  sortAscending(int[] array){

        for (int i = 1; i <=array.length ; i++) {
            for (int j = 0; j <array.length - 1 ; j++) {
                int a = array[j];
                int b = array[j+1];
                if(a >b){
                    int number1 = a;
                    int number2 = b;
                    array[j] = number2;
                    array[j+1] = number1;
                }
            }
        }
        return array;
    }

    public static int[] sortDescending(int[] array){
        for (int i = 1; i <= array.length ; i++) {
            for (int j = 0; j <array.length - 1 ; j++) {
                int a = array[j];
                int b = array[j+1];
                if(b > a){
                    int number1 = b;
                    int number2 = a;

                    array[j] = number1;
                    array[j+1] = number2;
                }
            }
        }
        return array;
    }
}
