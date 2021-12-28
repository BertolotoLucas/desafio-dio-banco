package br.com.lucasbertoloto.desafiodio.model.account;

import br.com.lucasbertoloto.desafiodio.exception.*;
import br.com.lucasbertoloto.desafiodio.model.Client;

import java.util.Objects;

public class SavingAccount extends Account{
    private final long identification;

    public SavingAccount(Client client) throws MaxNumberQuantityCheckingAccountsReachedException,
            MaxNumberQuantityAccountsReachedException, MaxNumberQuantitySavingAccountsReachedException,
            AddingSameAccountException, AccountWithAnotherClientException {
        this.client = client;
        this.balance = 0D;
        client.addAccount(this);
        IDENTIFICATION = IDENTIFICATION + 1;
        this.identification =  IDENTIFICATION;
    }

    public long getIdentification() {
        return identification;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavingAccount that = (SavingAccount) o;
        return identification == that.identification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification);
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "identification=" + identification +
                ", agency=" + AGENCY +
                ", client=" + client.getName() +
                ", balance=" + balance +
                '}';
    }
}
