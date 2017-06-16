package lesson8.arithmetic;

public class Arithmetic {
    int[] array;

    public Arithmetic() {
    }

    public Arithmetic(int[] array) {
        this.array = array;
    }

    boolean check(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int el : array) {
            if (max < el)
                max = el;
        }
        for (int el : array) {
            if (min > el)
                min = el;
        }
        int sum = min + max;
        if (sum > 100) {
            return true;
        }
        return false;

    }

}
