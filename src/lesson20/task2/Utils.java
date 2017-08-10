package lesson20.task2;

public class Utils {
    private int limitSimpleTransactionAmount;
    private int limitTransactionsPerDayCount;
    private int limitTransactionsPerDayAmount;
    private String[] citiesAllowed;

    public String[] getCitiesAllowed() {
        return citiesAllowed;
    }

    public void setCitiesAllowed(String[] citiesAllowed) {
        this.citiesAllowed = citiesAllowed;
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
