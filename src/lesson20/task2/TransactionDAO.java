package lesson20.task2;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[3];
    private Utils utils = new Utils();

    public Transaction[] getTransactions() {
        return transactions;
    }


    public Transaction save(Transaction transaction) throws Exception {
        Controller controller = new Controller();
        if (transaction == null)
            throw new BadRequestException("Method save in TransactionDAO class failed to complete. " +
                    "Null transaction not allowed to save");
        if (transaction.getAmount() < 0)
            throw new BadRequestException("Amount of transaction id " + transaction.getId() + " is not allowed." +
                    " Method save in TransactionDAO failed to complete");
        if (transaction.getId() < 0) {
            throw new BadRequestException("Transaction id "
                    + transaction.getId() + " is not allowed. Method save in TransactionDAO failed to complete");
        }
        if (transaction.getCity() == null) {
            throw new BadRequestException("City can't be null. Transaction id "
                    + transaction.getId() + " is not saved. Method save in TransactionDAO failed to complete");
        }
        if (transaction.getDescription() == null) {
            throw new BadRequestException("Description can't be null. Transaction id "
                    + transaction.getId() + " is not saved. Method save in TransactionDAO failed to complete");
        }
        if (transaction.getDateCreated() == null) {
            throw new BadRequestException("DateCreated can't be null. Transaction id "
                    + transaction.getId() + " is not saved. Method save in TransactionDAO failed to complete");


            try {
                findSameExistingFile(transaction);
                throw new BadRequestException("User with id " + transaction.getId() + " is already exist." +
                        " Method save in TransactionDAO class failed to complete. ");
            } catch (InternalServerException e) {
                System.out.println("Transaction with id " + transaction.getId() + " not found. Will be saved");
            }
            for (int i = 0; i < transactions.length; i++) {
                if (transactions[i] == null) {
                    transactions[i] = transaction;
                    return transaction;
                }
            }
        }
        throw new InternalServerException("Method save in TransactionDAO class" +
                " failed to complete. Not enough space for transaction with id " + transaction.getId());
    }

    public void transactionList() throws Exception {
        if (transactions.length == 0)
            throw new InternalServerException("Method transactionList in TransactionDAO failed to complete." +
                    " There is no any transaction in DB");
        System.out.println( Arrays.toString(transactions));
    }

    public Transaction[] transactionList(String city) throws Exception {
        if (!city.equals(cityAllowed(city)))
            throw new LimitExceeded("City of transaction is not allowed");

        int countTrByCity = 0;
        for (Transaction tr : transactions) {
            if (tr.getCity().equals(city))
                countTrByCity++;
        }

        if (countTrByCity == 0)
            throw new InternalServerException("Method transactionList by City in TransactionDAO " +
                    "failed to complete. DB doesn't contain any data of city " + city);

        Transaction[] trListByCity = new Transaction[countTrByCity];
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr.getCity().equals(city)) {
                trListByCity[index] = tr;
                index++;
            }
        }
        return trListByCity;

    }

    public Transaction[] transactionList(int amount) throws Exception {
        int countAmountDB = 0;
        for (Transaction tr : transactions) {
            if (tr.getAmount() == amount)
                countAmountDB++;
        }
        if (countAmountDB == 0)
            throw new InternalServerException("Method transactionList by Amount in TransactionDAO " +
                    "class failed to complete.DB doesn't contain any data of amount " + amount);
        Transaction[] trListByAmount = new Transaction[countAmountDB];
        int index = 0;
        for (Transaction tr :transactions) {
            if (tr.getAmount() == amount) {
                trListByAmount[index] = tr;
                index++;
            }
        }
        return trListByAmount;
    }


    public Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;

        for (Transaction transaction : transactions) {
            calendar.setTime(transaction.getDateCreated());
            int trMonth = calendar.get(Calendar.MONTH);
            int trDay = calendar.get(Calendar.DAY_OF_MONTH);

            if (trMonth == month && trDay == day)
                count++;
        }

        Transaction[] result = new Transaction[count];
        int index = 0;

        for (Transaction transaction : transactions) {
            calendar.setTime(transaction.getDateCreated());
            int trMonth = calendar.get(Calendar.MONTH);
            int trDay = calendar.get(Calendar.DAY_OF_MONTH);

            if (trMonth == month && trDay == day)
                result[index] = transaction;
        }
        return result;
    }

    public Transaction findSameExistingFile(Transaction transaction) throws Exception {
        if (getTransactions() == null)
            return null;
        for (int i = 0; i < getTransactions().length; i++) {
            for (Transaction tr : getTransactions()) {
                if (tr != null && tr.getId() == transaction.getId() &&
                        tr.getAmount() == transaction.getAmount() &&
                        tr.getCity().equals(transaction.getCity()) &&
                        tr.getDescription().equals(transaction.getDescription()) &&
                        tr.getType().equals(transaction.getType()))
                    return transaction;
            }
        }
        throw new InternalServerException("Transaction with id: " + transaction.getId() + " not found");
    }

    public String cityAllowed(String city) throws Exception {
        String[] citiesAllowed = new String[]{"Kiev", "Odesa", "Mykolayiv"};
        for (String el : citiesAllowed) {
            if (el.equals(city))
                return city;
        }
        throw new LimitExceeded("City with name " + city + " not found at list of allowed cities");
    }


}
