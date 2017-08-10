package lesson20.task2;

public class Utils {
    private int limitSimpleTransactionAmount;
    private int limitTransactionsPerDayCount;
    private int limitTransactionsPerDayAmount;
    private String[] cities;

    public Utils(int limitSimpleTransactionAmount, int limitTransactionsPerDayCount,
                 int limitTransactionsPerDayAmount, String[] cities) {
        this.limitSimpleTransactionAmount = limitSimpleTransactionAmount;
        this.limitTransactionsPerDayCount = limitTransactionsPerDayCount;
        this.limitTransactionsPerDayAmount = limitTransactionsPerDayAmount;
        this.cities = cities;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
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

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public void setLimitTransactionsPerDayCount(int limitTransactionsPerDayCount) {
        this.limitTransactionsPerDayCount = limitTransactionsPerDayCount;
    }
}
