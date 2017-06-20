package lesson12;
public class UkrainianBankSystem implements BankSystem {
    @Override
    public void withdraw(User user, int amount) {
/*int limitOfWithdrawal = user.getBank().getLimitOfWithdrawal();
        if(amount + user.getBank().getCommission(amount) > limitOfWithdrawal ){
            printWithdrawalErrorMsg(amount,user);
            return;
        }

        if (amount + user.getBank().getCommission(amount) > user.getBalance()){
            printWithdrawalErrorMsg(amount,user);
            return;
        }*/
        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
        // double balanceAfterWithdraw = user.getBalance() - amount -user.getBank().getCommission(amount);

    }

    @Override
    public void fund(User user, int amount) {

    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
//снимаем деньги с fromUser
        //пополняем toUser
        if (!checkWithdraw(fromUser, amount))
            return;
        //TODO checkfund rules
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        //TODO fund
    }

    @Override
    public void paySalary(User user) {

    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user" + user.toString());
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }
}
