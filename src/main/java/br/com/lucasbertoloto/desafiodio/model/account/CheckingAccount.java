package br.com.lucasbertoloto.desafiodio.model.account;

import br.com.lucasbertoloto.desafiodio.exception.*;

import java.util.Objects;

public class CheckingAccount extends Account{
    private Double monthlyFee;

    public CheckingAccount(Double monthlyFee) {
        super();
        this.monthlyFee = monthlyFee;
    }

    public Double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(Double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public void transfer(Double value, Account to) throws NoValueException, NegativeValueException,
            InsufficientBalanceException {
        to.deposit(value);
        this.withdraw(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckingAccount that = (CheckingAccount) o;
        return this.getIdentification() == that.getIdentification();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getIdentification());
    }

    @Override
    public String toString() {
        String clientName;
        if (client == null)
            clientName = "Null";
        else
            clientName = client.getName();
        return "CheckingAccount{" +
                "identification=" + this.getIdentification() +
                ", agency=" + AGENCY +
                ", client=" + clientName +
                ", balance=" + balance +
                ", monthlyFee=" + monthlyFee +
                '}';
    }

}
