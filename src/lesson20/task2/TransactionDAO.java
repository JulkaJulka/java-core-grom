package lesson20.task2;



import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 07.08.2017.
 */
public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];

    public Transaction[] getTransactions() {
        return transactions;
    }


    public Transaction save(Transaction transaction) throws Exception {
        if (transaction == null)
            throw new BadRequestException("Method save in TransactionDAO class failed to complete. " +
                    "Null transaction not allowed to save");

        try{
            findSameExistingFile(transaction);
            throw new BadRequestException("User with id " + transaction.getId() + " is already exist");
       } catch (Exception e){
            System.out.println("Transaction with id " + transaction.getId() + " not found. Will be saved");
        }
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;
                return transaction;
            }
        }
        throw new InternalServerException("Method save in TransactionDAO class" +
                " failed to complete. Not enough space");

      /*  int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null)
                tr[index] == transaction;
            index++;
        }*/


        //TODO check and save if ok

    }

    public Transaction[] transactionList() {
        return transactions;
    }

    public Transaction[] transactionList(String City) {
        return null;
    }

    public Transaction[] transactionList(int amount) {
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

  public   Transaction findSameExistingFile(Transaction transaction) throws Exception{
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
      throw new Exception("Transaction with id: " + transaction.getId() + " not found");
    }
}
