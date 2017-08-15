package lesson202;

/**
 * Created by user on 14.08.2017.
 */
public class Utils {
    private int limitSimpleTransactionAmount = 40;
    private int limitTransactionsPerDayCount = 10;
    private int limitTransactionsPerDayAmount = 100;
    private String[] cities={"Kiev", "Odessa"};

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
