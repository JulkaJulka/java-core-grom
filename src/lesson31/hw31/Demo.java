package lesson31.hw31;

/**
 * Created by user on 23.10.2017.
 */
public class Demo {
    public static void main(String[] args) {
        String  str = "e dfdzzzzg78fh jkl&lll ytuit tyu tyu hjkhl fgh fgh fgh";
        Solution solution = new Solution();
        solution.countSymbols(str);
        System.out.println(solution.toString());


        System.out.println("---Test1----countSymbals");
        System.out.println(solution.countSymbols(str));
        System.out.println();

        System.out.println("---Test2----countSymbals");
        String str1 = "";
        System.out.println(solution.countSymbols(str1));

        System.out.println("---Test3----countSymbals");
        String str2 = " 57859 hgj j 7";
        System.out.println(solution.countSymbols(str2));
        System.out.println();

        System.out.println("---Test4----countSymbals");
        String str3 = "рпоп лплп";
        System.out.println(solution.countSymbols(str3));
        System.out.println();

        System.out.println("---Test5----countSymbals");
        String str4 = "768589 5985 50)";
        System.out.println(solution.countSymbols(str4));

        System.out.println("---Test6----words");
        System.out.println(solution.words(str));
        System.out.println();

        System.out.println("---Test7----words_any chars");
        String str5 = "768589 5985 50)";
        System.out.println(solution.words(str5));
        System.out.println();

        System.out.println("---Test8----words_empty string");
        String str6 = "";
        System.out.println(solution.words(str6));
        System.out.println();

        System.out.println("---Test9----words_length = 2");
        String str7 = "hj kj 45 978";
        System.out.println(solution.words(str7));
        System.out.println();

        System.out.println("---Test10----words");
        String str8 = "I buy bus car ball ball ball car dog";
        System.out.println(solution.words(str8));
        System.out.println();

    }
}
