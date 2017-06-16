package lesson1;

import lesson9.utils.Checker;

/**
 * Created by user on 25.05.2017.
 */
public class FirstProgram {
    public static void main(String args[]){
        System.out.println("My first Java program...");
        System.out.println("Done");
        Checker checker = new Checker();
        System.out.println(checker.checkCompanyName("Google"));

    }
}
