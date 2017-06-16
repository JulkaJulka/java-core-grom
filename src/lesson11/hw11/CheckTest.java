package lesson11.hw11;

/**
 * Created by user on 15.06.2017.
 */
public class CheckTest {
    public static void main(String[] args) {
        int[] mas1 = {3, 7, 89, 364};
        int[] mas2 = {7,6,364,90, 89,900};
        check(mas1, mas2);
        //System.out.println(check(mas1, mas2));

    }
    public  static int[] check(int[] mas1, int[] mas2){

        if(mas1 == null || mas2 == null){
            return null;
        }
        int[] res = new int[mas1.length];
        for (int i = 0; i <mas1.length ; i++) {
            for (int j = 0; j < mas2.length; j++) {
                if(mas1[i] == mas2[j]) {
                    res[i] = mas1[i];
                   System.out.print(res[i] + " ");
                }
                }
        }
        return res;
    }
}
