package lesson9.utils;

/**
 * Created by user on 25.05.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Checker checker = new Checker();
        System.out.println(checker.companyNamesValidatedCount);
        System.out.println(checker.checkCompanyName("Google"));

    }
}
