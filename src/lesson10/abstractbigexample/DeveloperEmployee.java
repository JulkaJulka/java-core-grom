package lesson10.abstractbigexample;

/**
 * Created by user on 08.06.2017.
 */
public class DeveloperEmployee extends Employee{
    private String[] frameWorks = new String[10];

    @Override
    void paySalary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth() + 1000;
        getBankAccount().setBalance(newBalance);
    }
}
