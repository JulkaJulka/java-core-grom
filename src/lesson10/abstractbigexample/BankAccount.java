package lesson10.abstractbigexample;

/**
 * Created by user on 08.06.2017.
 */
public class BankAccount {
    private Employee employee;
    private int balance;

    public BankAccount(Employee employee, int balance) {
        this.employee = employee;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }



    public void setBalance(int balance) {
        this.balance = balance;
    }
}
