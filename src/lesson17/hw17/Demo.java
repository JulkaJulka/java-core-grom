package lesson17.hw17;

/**
 * Created by user on 31.07.2017.
 */
public class Demo {
    public static void main(String[] args) {
        SolutionByAndrey solutionByAndrey = new SolutionByAndrey();
        solutionByAndrey.validate("https://www.test.com");
        System.out.println(solutionByAndrey.validate("http://wwwtest.com"));
    }
}
