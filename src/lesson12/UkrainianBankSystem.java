package lesson12;
public class UkrainianBankSystem implements BankSystem {
    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
/*int limitOfWithdrawal = user.getBank().getLimitOfWithdrawal();
        if(amount + user.getBank().getCommission(amount) > limitOfWithdrawal ){
            printWithdrawalErrorMsg(amount,user);
            return;
        }

        if (amount + user.getBank().getCommission(amount) > user.getBalance()){
            printWithdrawalErrorMsg(amount,user);
            return;
        }*/

    }

    @Override
    public void fund(User user, int amount) {
        if(!checkFund(user,amount))
            return;
        user.setBalance(user.getBalance() + amount);

/*if(amount > user.getBank().getLimitOfFunding()){
    System.err.println("Can't fund money " + amount + " to user" + user.toString());
} else{
    user.setBalance(user.getBalance() + amount);
}*/
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
//снимаем деньги с fromUser
        //пополняем toUser
        if (!checkWithdraw(fromUser, amount) )
            return;
        // checkfund rules
        if(!checkFund(toUser,amount))
            return;

        withdraw(fromUser, amount);
      //  fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        // fund
        fund(toUser,amount);
    }

    @Override
    public void paySalary(User user) {
        if(!checkFund(user,user.getSalary()))
            return;
        user.setBalance(user.getBalance() + user.getSalary());

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
    private void printFundErrorMsg(int amount, User user) {
        System.err.println("Can't fund money " + amount + " to user" + user.toString());
    }

    private boolean checkFundLimits(User user, int amount, double limit){
        if(amount > user.getBank().getLimitOfFunding()) {
            printFundErrorMsg(amount,user);
            return false;
        }
        return true;
    }
    private boolean checkFund(User user, int amount) {
        return checkFundLimits(user, amount, user.getBank().getLimitOfFunding());
    }
}
