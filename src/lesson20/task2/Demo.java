package lesson20.task2;

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
        Transaction transaction3 = new Transaction(2,"Kiev", 20, "description", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(3,"Odesa", 20, "description", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(4,"Odesa", 500, "description", TransactionType.INCOME, new Date());
        TransactionDAO transactionDAO = new TransactionDAO();
        Transaction[] transactions = {transaction1, null};

        System.out.println("---Test1---transactionDAO.save");
        System.out.println(transactionDAO.save(transaction1));
        System.out.println();

       System.out.println("---Test2---transactionDAO.save the same transaction");
        try{System.out.println(transactionDAO.save(transaction2));
    } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Test Pass");
        }
        System.out.println();
        System.out.println(Arrays.toString(transactionDAO.getTransactions()));
        System.out.println();

        System.out.println("---Test4---");
        System.out.println(controller.saveTransaction(transaction3));

        System.out.println("---Test3---transactionDAO.save full space");
        try {
            System.out.println(transactionDAO.save(transaction3));
            System.out.println(transactionDAO.save(transaction4));
            System.out.println(transactionDAO.save(transaction5));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();



        System.out.println("---Test40---transactionDAO.transactionList");
        System.out.println(Arrays.toString(transactionDAO.transactionList()));
        System.out.println();

        System.out.println("---Test50---controller.transactionList");
        System.out.println(Arrays.toString(controller.transactionList()));
    }


}
