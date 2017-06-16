/**
 * Created by user on 28.03.2017.
 */
public class ReduceBalance {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};
        System.out.println(withdraw(names,balances,"Ann",500 ));

    }
    static int withdraw(String[] clients, int[] balances, String client, int amount) {
        // 1. найти клиента в базе
        //2. уменьшить на заданную величину баланс, соответствующий индексу п.2

        //1
        int clientIndex = 0;
        int index = 0;
        for (String el : clients) {
            if (el == client) {
                break;
            }
            index++;
        }
        clientIndex = index;
        //System.out.println(clientIndex);

        //2
            int reduceBalance = balances[clientIndex] >= amount ? balances[clientIndex] -= amount : -1;
        return reduceBalance;
        }
}
