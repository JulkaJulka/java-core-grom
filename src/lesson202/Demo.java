package lesson202;

import java.util.Arrays;
import java.util.Date;


public class Demo {
    public static void main(String[] args) throws Exception {
      //Controller controller = new Controller();
        Controller controller1 = new Controller();
        TransactionDAO transactionDAO = new TransactionDAO();

        Transaction transaction1 = new Transaction(1, "Odessa", 20, "description", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(1, "Odessa", 20, "description", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(2, "Kiev", 20, "description", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(3, "Odessa", 20, "description", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(4, "Odessa", 20, "description", TransactionType.INCOME, new Date());

        Transaction transaction10 = new Transaction(10, "Odesa", 10, "description",
                TransactionType.OUTCOME, new Date());
        Transaction transaction11 = new Transaction(10, "Odesa", 10, "description",
                TransactionType.OUTCOME, new Date());
      //  Transaction transaction13 = new Transaction(null,null);

        System.out.println("---Test1---transactionDAO.save");
        System.out.println(transactionDAO.save(transaction1));

        System.out.println();
        System.out.println(Arrays.toString(transactionDAO.transactionList()));

        System.out.println("---Test2---transactionDAO.save the same transaction");
        try {
            System.out.println(transactionDAO.save(transaction2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Test Pass");
        }
        System.out.println();
        System.out.println(Arrays.toString(transactionDAO.transactionList()));
        System.out.println();

       /* System.out.println("---Test3---transactionDAO.save full space");
        System.out.println(controller.transactionDAO.save(transaction3));
        System.out.println(controller.transactionDAO.save(transaction4));
        System.out.println(Arrays.toString(controller.transactionDAO.transactionList()));
        try {

            System.out.println(controller.transactionDAO.save(transaction5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Arrays.toString(controller.transactionDAO.transactionList()));
        System.out.println();

        System.out.println("---Test4---transactionDAO.transactionList");
        System.out.println(Arrays.toString(controller.transactionDAO.transactionList()));
        System.out.println();

        System.out.println("---Test5---transactionDAO.transactionListByAmount");
        System.out.println(Arrays.toString(controller.transactionDAO.transactionList(20)));
        System.out.println();

        System.out.println("---Test6---transactionDAO.transactionListByAmount_amount is not existing in DB");
        try {
            System.out.println(Arrays.toString(controller.transactionDAO.transactionList(10)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("---Test7---transactionDAO.transactionListByCity");
        System.out.println(Arrays.toString(controller.transactionDAO.transactionList("Odessa")));
        System.out.println();

        System.out.println("---Test8---transactionDAO.transactionListByCity_allowed city is not existing in DB");
        try{
            System.out.println(Arrays.toString(controller.transactionDAO.transactionList("Mykolayiv")));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("---Test9---transactionDAO.transactionListByCity_not allowed city ");
        try{
            System.out.println(Arrays.toString(controller.transactionDAO.transactionList("Lviv")));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("---Test10---controller.saveTransaction with Amount exceeded");
        try{
            System.out.println(controller.save(transaction1));
        } catch (Exception e){
            System.out.println( e.getMessage());
        }
        System.out.println();

        System.out.println("---Test11---controller.transactionList() ");
        System.out.println(Arrays.toString(controller.transactionList()));
        System.out.println();

        System.out.println("---Test12---controller.transactionList by City ");
        System.out.println(Arrays.toString(controller.transactionList("Odessa")));
        System.out.println();

        System.out.println("---Test13---controller.transactionList by City not allowed ");
        try{
            System.out.println(Arrays.toString(controller.transactionList("Lviv")));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("---Test14---controller.transactionList by City is not exissting in DB ");
        try{
            System.out.println(Arrays.toString(controller.transactionList("Mykolayiv")));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("---Test15---controller.transactionListByAmount");
        System.out.println(Arrays.toString(controller.transactionList(20)));
        System.out.println();

        System.out.println("---Test16---controller.transactionListByAmount_amount is not existing in DB");
        try {
            System.out.println(Arrays.toString(controller.transactionList(10)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();*/

        }

    }


