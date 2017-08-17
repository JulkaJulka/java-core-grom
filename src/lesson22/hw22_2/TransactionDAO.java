package lesson22.hw22_2;

import lesson22.hw22_2.Exception.BadRequestException;
import lesson22.hw22_2.Exception.InternalServerException;
import lesson22.hw22_2.Exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 14.08.2017.
 */
public class TransactionDAO {

    private static Transaction[] transactions = new Transaction[10];
    private static Utils utils = new Utils();

    public static Transaction save(Transaction transaction) throws Exception {
        if (transaction == null)
            return null;
        //ограничения
        //не хватило места в базе
        validate(transaction);
        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction))
               throw new BadRequestException("Transaction with id " + transaction.getId() + " is already exist." +
                     " Method save in TransactionDAO class failed to complete.");
        }
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null){
                transactions[i] = transaction;

        return transaction;}
        }
        return null;

    }

    private static void validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > Utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit per day amount " + transaction.getId() + " exceeded.");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }
        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount())
            throw new lesson22.hw22_2.Exception.LimitExceeded("Transaction limit per day amount "
                    + transaction.getId() + " exceeded." +
                    " Method saveTransaction in Controller failed to complete");
        if (count + 1 > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded. Transaction id "
                    + transaction.getId() + " is not saved");
      if(cityAllowed(transaction.getCity()) == null)
                throw new BadRequestException("City with name " + transaction.getCity() +
                       " not found at list of allowed cities" +
                        "Transaction id " + transaction.getId() + " can't be save");

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

   public static Transaction[] transactionList(){
       //if(transactions == null)
      //     throw new InternalServerException("TransactionList is empty");
       int countFullPosition = 0;
       for (Transaction tr:transactions) {
           if(tr != null){
               countFullPosition++;
           }
       }
       if(countFullPosition == 0)
           return new Transaction[] {};
          // throw new InternalServerException("TransactionList is empty");
       Transaction[] trList = new Transaction[countFullPosition];
       int index = 0;
       for (Transaction tr:transactions) {
           if(tr != null){
               trList[index] = tr;
               index++;
           }
       }
        return trList;
    }

    public static Transaction[] transactionList(String city) {

       /* if (!city.equals(cityAllowed(city)))
            throw new LimitExceeded("City of transaction is not allowed. " +
                    "Method transactionList by City in TransactionDAO" +
                    " is failed to complete");*/

        int countTrByCity = 0;
        for (Transaction tr : transactionList()) {
            if (tr.getCity().equals(city))
                countTrByCity++;
        }

        if (countTrByCity == 0)
            return new Transaction[] {};
            //throw new InternalServerException("DB doesn't contain any data of city " + city +
               //     ". Method transactionList by City in Controller is failed to complete");

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

   public static Transaction[] transactionList(int amount){

       int countAmountDB = 0;
       for (Transaction tr : transactionList()) {
           if (tr.getAmount() == amount)
               countAmountDB++;
       }
       if (countAmountDB == 0)
           return new Transaction[] {};
           //throw new InternalServerException("DB doesn't contain any data of amount " + amount +
                //   ". Method transactionList by Amount in TransactionDAO is failed to complete");
       Transaction[] trListByAmount = new Transaction[countAmountDB];
       int index = 0;
       for (Transaction tr : transactionList()) {
           if (tr.getAmount() == amount) {
               trListByAmount[index] = tr;
               index++;
           }
       }
       return trListByAmount;
    }

    public static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
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

    public static String cityAllowed(String city) throws Exception {
        for (String el : utils.getCities()) {
            if (el.equals(city))
                return city;
        }
        return null;
        //throw new LimitExceeded("City with name " + city + " not found at list of allowed cities");
    }
}
