package lesson5;

/**
 * Created by user on 27.03.2017.
 */
public class ArraysPractice {
    public static void main(String[] args) {
        int[] array = {-10,0,110,555,1000,-45,0,60, 10};
        System.out.println(maxElement(array));

        System.out.println(nCount(array,0));

    }
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
}
