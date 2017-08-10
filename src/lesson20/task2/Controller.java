package lesson20.task2;

public class Controller {

    //bad way
    public TransactionDAO transactionDAO = new TransactionDAO();
    private Utils utils = new Utils();

    public Controller() {
        utils.setLimitTransactionsPerDayCount(10);
        utils.setLimitSimpleTransactionAmount(100);
        utils.setLimitTransactionsPerDayAmount(40);
        utils.setCities(new String[]{"Kiev", "Odesa", "Mykolayiv"});
    }


   public Transaction save(Transaction transaction) throws Exception {
        Transaction[] transactions = transactionDAO.getTransactionsPerDay(transaction.getDateCreated());

        if (transaction.getAmount() > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Amount of transaction id " + transaction.getId() + " exceeded." +
                    " Method saveTransaction in Controller failed to complete" );

        if (transactions.length + 1 > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Count of transactions per day exceeded. Transaction id "
                    + transaction.getId() + " is not saved");
        }

        if (transactionsPerDayAmount(transactions) + transaction.getAmount() > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Amount of transactions per day exceeded. Transaction id "
                    + transaction.getId() + " is not saved");
        }

        if (!transaction.getCity().equals(cityAllowed(transaction.getCity()))) {
            throw new LimitExceeded("City of transaction is not allowed. Transaction id "
                    + transaction.getId() + " is not saved. Method saveTransaction in Controller" +
                    " is failed to complete");
        }
        transactionDAO.save(transaction);
        return transaction;
    }

   public Transaction[] transactionList() {

        return transactionDAO.getTransactions();
    }

   public Transaction[] transactionList(String city) throws Exception {
        if (!city.equals(cityAllowed(city)))
            throw new LimitExceeded("City of transaction is not allowed. Method transactionList by City in Controller" +
                    " is failed to complete");

        int countTrByCity = 0;
        for (Transaction tr : transactionList()) {
            if (tr.getCity().equals(city))
                countTrByCity++;
        }

        if (countTrByCity == 0)
            throw new InternalServerException("DB doesn't contain any data of city " + city +
                    ". Method transactionList by City in Controller is failed to complete");

        Transaction[] trListByCity = new Transaction[countTrByCity];
        int index = 0;
        for (Transaction tr : transactionList()) {
            if (tr.getCity().equals(city)) {
                trListByCity[index] = tr;
                index++;
            }
        }
        return trListByCity;
    }

    public Transaction[] transactionList(int amount) throws Exception {
        int countAmountDB = 0;
        for (Transaction tr : transactionList()) {
            if (tr.getAmount() == amount)
                countAmountDB++;
        }
        if (countAmountDB == 0)
            throw new InternalServerException("DB doesn't contain any data of amount " + amount +
                    ". Method transactionList by Amount in Controller is failed to complete");
        Transaction[] trListByAmount = new Transaction[countAmountDB];
        int index = 0;
        for (Transaction tr : transactionList()) {
            if (tr.getAmount() == amount)
                trListByAmount[index] = tr;
            index++;
        }
        return trListByAmount;
    }

    private int transactionsPerDayAmount(Transaction[] transactions) {
        int amount = 0;
        for (Transaction tr : transactions) {
            amount += tr.getAmount();
        }
        return amount;
    }

    public String cityAllowed(String city) {
        String[] citiesAllowed = new String[]{"Kiev", "Odesa", "Mykolayiv"};
        for (String el : citiesAllowed) {
            if (el.equals(city))
                return city;
        }
        return null;
    }
}
