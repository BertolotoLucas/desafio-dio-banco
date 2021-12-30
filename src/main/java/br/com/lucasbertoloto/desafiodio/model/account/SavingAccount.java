package br.com.lucasbertoloto.desafiodio.model.account;

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
        String clientName;
        if (client == null)
            clientName = "Null";
        else
            clientName = client.getName();
        return "SavingAccount{" +
                "identification=" + this.getIdentification() +
                ", agency=" + AGENCY +
                ", client=" + clientName +
                ", balance=" + balance +
                '}';
    }
}
