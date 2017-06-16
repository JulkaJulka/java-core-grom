import java.util.Arrays;

/**
 * Created by user on 27.03.2017.
 */
public class BanksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};
        System.out.println(Arrays.toString(findClientsByBalance(names,balances,-100)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names,balances)));

        depositMoney(names,balances,"Ann",2000);
        System.out.println(Arrays.toString(balances));
    }

     static String[] findClientsByBalance(String[] clients, int[] balances, int n) {
        int count = 0;
        for (int balance : balances) {
            if (balance >= n)
                count++;
        }
        String[] results = new String[count];

        int index = 0;
         int resIndex =0;

        for (int balance : balances) {
            if (balance >= n){
                results[resIndex] = clients[index];
                resIndex++;
        }
        index++;
    }

    return results;
}

    static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
           int count = 0;
           for (int balance : balances) {
              if (balance < 0)
                  count++;
              }
           String[] results = new String[count];
        int index = 0;
        int resIndex = 0;
        for (int balance:balances) {
            if(balances[index] < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    static void depositMoney(String[] clients, int[] balances, String client, int money) {
        // 1. найти клиента в базе(в массиве)
        // 2. просчет суммы с учетом комиссииж
        // 3. обновляем баланс()пополняем

        //1
       //int clientIndex = findIndexByName(clients,client);

        //2
       // int moneyToDeposit = calculateDepositAmountAfterCommission(money);

        //3
        balances[findClientIndexByName(clients,client)] += calculateDepositAmountAfterCommission(money);

    }
    static int findClientIndexByName(String[] clients, String client){
        int clientIndex = 0;
        for (String el: clients ){
            if(el == client){
                break;
            }
            clientIndex++;
        }
        return clientIndex;
    }

    static int calculateDepositAmountAfterCommission(int money){
        int moneyToDeposit = money <= 100 ? (int)(money - money * 0.02 ): (int)(money - money * 0.01);
        return moneyToDeposit;
    }

    /*static  int withdraw(String[] clients, int[] balances, String client, int amount) {
        // 1. найти клиента в базе;
        // 2. уменьшить баланс на величину;
        //int resIndex = 0;
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client){
                break;
        }
        clientIndex++;
    }
    return clientIndex;
        for (int balance:balances) {

        }


        return 0;
    }*/
}
