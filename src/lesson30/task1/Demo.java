package lesson30.task1;

/**
 * Created by user on 02.10.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        User user1 = new User(1001, "Denis", 52200, 40, "GMD", 1500, usBank);
        UkrainianBankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(user1, 150);
        Thread.sleep(2000);
        bankSystem.withdraw(user1, 10);
        System.out.println(bankSystem.getTransactions());
    }
}
