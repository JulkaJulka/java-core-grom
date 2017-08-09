package lesson20.task2;

public class Controller {

    //bad way
    private TransactionDAO transactionDAO = new TransactionDAO();
    private Utils utils = new Utils();

    public Controller() {
        utils.setCountOfTransactionsPerDay(5);
        utils.setSumAmountOfTransactionsPerDay(100);
        utils.setTransactionAmountLimit(40);
        utils.setCitiesAllowed(new String[]{"Kiev", "Odesa", "Mykolayiv"});
    }

    Transaction saveTransaction(Transaction transaction) throws Exception {
        Transaction[] transactions = transactionDAO.getTransactionsPerDay(transaction.getDateCreated());

        if (transaction.getAmount() > utils.getTransactionAmountLimit())
            throw new LimitExceeded("Amount of this transaction exceeded");

        if (transactions.length + 1 > utils.getCountOfTransactionsPerDay()) {
            throw new LimitExceeded("Count of transactions per day exceeded");
        }

        if (transactionsPerDayAmount(transactions) + transaction.getAmount() > utils.getSumAmountOfTransactionsPerDay()) {
            throw new LimitExceeded("Amount of transactions per day exceeded");
        }

        if (!transaction.getCity().equals(cityAllowed(transaction.getCity()))) {
            throw new LimitExceeded("City of transaction is not allowed");
        }
        transactionDAO.save(transaction);
        return transaction;
    }

    Transaction[] transactionList() {

        return null;
    }

    Transaction[] transactionList(String city) throws Exception {
        if (!city.equals(cityAllowed(city)))
            throw new LimitExceeded("City of transaction is not allowed");

        int countTrByCity = 0;
        for (Transaction tr : transactionList()) {
            if (tr.getCity().equals(city))
                countTrByCity++;
        }

        if (countTrByCity == 0)
            throw new InternalServerException("DB doesn't contain any data of city " + city);

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

    Transaction[] transactionList(int amount) throws Exception {
        int countAmountDB = 0;
        for (Transaction tr : transactionList()) {
            if (tr.getAmount() == amount)
                countAmountDB++;
        }
        if (countAmountDB == 0)
            throw new InternalServerException("DB doesn't contain any data of amount " + amount);
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
