package lesson12;

/**
 * Created by user on 20.06.2017.
 */
public class ChinaBank extends Bank {
    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees,
                     double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if(getCurrency() == Currency.USD)
        return 100;
        return 150;
    }

    @Override
    public int getLimitOfFunding() {
        if(getCurrency() == Currency.USD)
        return 10000;
        return 5000;
    }

    @Override
    public double getMonthlyRate() {
        if(getCurrency() == Currency.USD)
            return 0.01;
        return 0.00;
    }

    @Override
    public double getCommission(int amount) {
        if(getCurrency() == Currency.USD){
            if (amount <= 1000)
                return 0.03;
            return 0.05;
        } else {
            if (amount <= 1000)
                return 0.1;
            return 0.11;
        }
    }
}
