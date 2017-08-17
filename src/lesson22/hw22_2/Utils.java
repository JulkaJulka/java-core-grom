package lesson22.hw22_2;

/**
 * Created by user on 14.08.2017.
 */
public class Utils {
    private static int limitSimpleTransactionAmount = 40;
    private static int limitTransactionsPerDayCount = 10;
    private static int limitTransactionsPerDayAmount = 100;
    private static String[] cities={"Kiev", "Odessa"};

    public static int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public static int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public static int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public static String[] getCities() {
        return cities;
    }
}
