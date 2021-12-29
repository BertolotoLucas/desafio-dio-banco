package br.com.lucasbertoloto.desafiodio.model.account;

import br.com.lucasbertoloto.desafiodio.exception.*;
import br.com.lucasbertoloto.desafiodio.model.Client;

import java.util.Objects;

public class SavingAccount extends Account{
    public SavingAccount() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavingAccount that = (SavingAccount) o;
        return this.getIdentification() == that.getIdentification();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getIdentification());
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "identification=" + this.getIdentification() +
                ", agency=" + AGENCY +
                ", client=" + client.getName() +
                ", balance=" + balance +
                '}';
    }
}
