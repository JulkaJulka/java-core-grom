package lesson22.hw22_2;

/**
 * Created by user on 14.08.2017.
 */
public class Controller {

    private static TransactionDAO transactionDAO = new TransactionDAO();

    public static Transaction save(Transaction transaction) throws Exception{
        return transactionDAO.save(transaction);
    }

    public static Transaction[] transactionList() throws Exception{

        return transactionDAO.transactionList();
    }

    public static Transaction[] transactionList(String city) throws Exception{
        return transactionDAO.transactionList(city);
    }

    public static Transaction[] transactionList(int amount) throws Exception{
        return transactionDAO.transactionList(amount);
    }
}
