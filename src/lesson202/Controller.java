package lesson202;

import lesson202.Exception.LimitExceeded;

/**
 * Created by user on 14.08.2017.
 */
public class Controller {

    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws LimitExceeded{
        return transactionDAO.save(transaction);
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
}
