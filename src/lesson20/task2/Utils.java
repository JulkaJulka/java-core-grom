package lesson20.task2;

public class Utils {
    private int limitSimpleTransactionAmount;
    private int limitTransactionsPerDayCount;
    private int limitTransactionsPerDayAmount;
    private String[] cities;

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public void setLimitTransactionsPerDayCount(int limitTransactionsPerDayCount) {
        this.limitTransactionsPerDayCount = limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public void setLimitTransactionsPerDayAmount(int limitTransactionsPerDayAmount) {
        this.limitTransactionsPerDayAmount = limitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public void setLimitSimpleTransactionAmount(int limitSimpleTransactionAmount) {
        this.limitSimpleTransactionAmount = limitSimpleTransactionAmount;
    }
}
