package lesson25;

import lesson24.exercise.*;

/**
 * Created by user on 20.08.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();
        Order order = new Order(1);
        generalDAO.validate(order);

        TestClass<String, Order, Long> testClass = new TestClass<>();
        System.out.println(testClass.doSomething1("ггг"));

        //long - Long
        //int - Integer
        //short - Short
int test = 100;
        long variable = 111;
        Long variable2 = new Long(222);

        generalDAO.validate(test);

       // Long variable3 = (Long) variable;

        generalDAO.validate(variable);
    }
}
