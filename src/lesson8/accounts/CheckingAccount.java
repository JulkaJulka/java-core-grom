package lesson8.accounts;

/**
 * Created by user on 17.05.2017.
 */
public class CheckingAccount extends Account {
    int limitOFExpenses;

    public CheckingAccount(String bankName, String ownerName, int moneyAmount, int limitOFExpenses) {
        super(bankName, ownerName, moneyAmount);
        this.limitOFExpenses = limitOFExpenses;
    }


    void withdraw(int amount){
        if(amount > limitOFExpenses)
            return;
        moneyAmount -= amount;
    }
}
