package lesson18.exercise2;

/**
 * Created by user on 19.07.2017.
 */
public class Converter {
    public static void main(String[] args) {
        System.out.println("---test1---");
        System.out.println(intToString(111321));

        System.out.println("---test2---");
        System.out.println(stringToInt("11"));

        System.out.println();
        System.out.println("---test3---");
        System.out.println(stringToInt("1050a"));

        System.out.println("---test4---");
        System.out.println(stringToInt("777777777777777"));

        System.out.println("---test5---");
        System.out.println(stringToInt(""));


        System.out.println(intToString(111321));
        System.out.println(stringToInt("11"));

        System.out.println(intToString(111321));
        System.out.println(stringToInt("11"));
    }

    public static String intToString(int input) {
        return String.valueOf(input);
    }

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException | ClassCastException e) {
            System.out.println(input + " can not be converted to int");
            return 0;
        }


    }
}
