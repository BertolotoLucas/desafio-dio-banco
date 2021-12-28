package br.com.lucasbertoloto.desafiodio.model.account;

import br.com.lucasbertoloto.desafiodio.model.Client;

import java.util.Objects;

public class CheckingAccount extends Account{
    private final long identification;

    public CheckingAccount(Client client) {
        this.client = client;
        this.balance = 0D;
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
        CheckingAccount that = (CheckingAccount) o;
        return identification == that.identification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification);
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "identification=" + identification +
                ", agency=" + AGENCY +
                ", client=" + client.getNome() +
                ", balance=" + balance +
                '}';
    }

}
