package lesson20.task2.exception;

import lesson20.task2.Controller;
import lesson20.task2.Transaction;
import lesson20.task2.TransactionDAO;
import lesson20.task2.TransactionType;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by user on 07.08.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        String city = "";
        //System.out.println(controller.cityAllowed(city));

       // Transaction transaction1;
        Transaction transaction1 = new Transaction(1,"Odesa", 500, "description", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(1,"Odesa", 500, "description", TransactionType.INCOME, new Date());
        TransactionDAO transactionDAO = new TransactionDAO();
        Transaction[] transactions = {transaction1, null};

        System.out.println("---Test1---transactionDAO.save");
        System.out.println(transactionDAO.save(transaction1));
        System.out.println();

        System.out.println("---Test2---transactionDAO.save the same transaction");
        System.out.println(transactionDAO.save(transaction2));
        System.out.println();
        System.out.println(Arrays.toString(transactionDAO.getTransactions()));

       /* System.out.println(transactionDAO.findSameExistingFile(transaction2));
        System.out.println();
        System.out.println(transactionDAO.save(transaction2));*/

    }
}
