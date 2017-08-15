package lesson202;

import lesson202.Exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 14.08.2017.
 */
public class TransactionDAO {

    private Transaction[] transactions =new Transaction[10];
    private Utils utils = new Utils();

   public Transaction save(Transaction transaction) throws LimitExceeded{
       //ограничения
       //не хватило места в базе



return transaction;
    }

    private void validate(Transaction transaction) throws LimitExceeded{
        if(transaction.getAmount()> utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr:getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }
        if(sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount " + transaction.getId() + " exceeded." +
                    " Method saveTransaction in Controller failed to complete");
        if(count > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded. Transaction id "
                    + transaction.getId() + " is not saved");
        //TODO
    }

    Transaction[] transactionList(){
        return null;
    }

    Transaction[] transactionList(String city){
        return null;
    }

    Transaction[] transactionList(int amount){
        return null;
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
}
