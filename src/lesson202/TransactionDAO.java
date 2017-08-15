package lesson202;

import lesson202.Exception.BadRequestException;
import lesson202.Exception.InternalServerException;
import lesson202.Exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 14.08.2017.
 */
public class TransactionDAO {

    private Transaction[] transactions = new Transaction[3];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        if (transaction == null)
            throw new BadRequestException("Can't save null user");
        //ограничения
        //не хватило места в базе
        validate(transaction);
        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction))
                throw new BadRequestException("User with id " + transaction.getId() + " is already exist." +
                        " Method save in TransactionDAO class failed to complete.");
        }
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null){
                transactions[i] = transaction;

        return transaction;}
        }
        throw new InternalServerException("Unexpected error");

    }

    private void validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }
        if (sum + 1 > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount " + transaction.getId() + " exceeded." +
                    " Method saveTransaction in Controller failed to complete");
        if (count + 1 > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded. Transaction id "
                    + transaction.getId() + " is not saved");
      if(cityAllowed(transaction.getCity()) == null)
                throw new BadRequestException("City with name " + transaction.getCity() +
                       " not found at list of allowed cities");

        int countNull = 0;
        for (Transaction tr : transactions) {
            if (tr == null)
                countNull++;
        }
        if (countNull == 0) {
            throw new InternalServerException("Method save in TransactionDAO class " +
                    "failed to complete. Not enough space for transaction with id " + transaction.getId());
        }

    }

   public Transaction[] transactionList() throws InternalServerException {
        return transactions;
    }

    public Transaction[] transactionList(String city) throws Exception {

        if (!city.equals(cityAllowed(city)))
            throw new LimitExceeded("City of transaction is not allowed. " +
                    "Method transactionList by City in TransactionDAO" +
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

   public Transaction[] transactionList(int amount) throws Exception{

       int countAmountDB = 0;
       for (Transaction tr : transactionList()) {
           if (tr.getAmount() == amount)
               countAmountDB++;
       }
       if (countAmountDB == 0)
           throw new InternalServerException("DB doesn't contain any data of amount " + amount +
                   ". Method transactionList by Amount in TransactionDAO is failed to complete");
       Transaction[] trListByAmount = new Transaction[countAmountDB];
       int index = 0;
       for (Transaction tr : transactionList()) {
           if (tr.getAmount() == amount)
               trListByAmount[index] = tr;
           index++;
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
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;

        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day){
                    result[index] = transaction;
                index++;
            }
        }
    }
        return result;

    }

    public String cityAllowed(String city) throws Exception {
        for (String el : utils.getCities()) {
            if (el.equals(city))
                return city;
        }
        return null;
        //throw new LimitExceeded("City with name " + city + " not found at list of allowed cities");
    }
}
