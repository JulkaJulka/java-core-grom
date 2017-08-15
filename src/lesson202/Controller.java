package lesson202;

import lesson202.Exception.LimitExceeded;

/**
 * Created by user on 14.08.2017.
 */
public class Controller {

    public TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception{
        return transactionDAO.save(transaction);
    }

    public Transaction[] transactionList() throws Exception{

        return transactionDAO.transactionList();
    }

    public Transaction[] transactionList(String city) throws Exception{
        return transactionDAO.transactionList(city);
    }

    public Transaction[] transactionList(int amount) throws Exception{
        return transactionDAO.transactionList(amount);
    }
}
