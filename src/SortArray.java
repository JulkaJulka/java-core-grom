import java.util.Arrays;

/**
 * Created by user on 27.03.2017.
 */
public class SortArray {
    public static void main(String[] args) {
        int[] test = new int[]{14,5,78,10,5};
       // sortAscending(test);
       System.out.println(Arrays.toString(sortAscending(test)));
        System.out.println(Arrays.toString(sortDescending(test)));
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




