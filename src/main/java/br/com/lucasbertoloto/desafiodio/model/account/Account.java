package br.com.lucasbertoloto.desafiodio.model.account;

import br.com.lucasbertoloto.desafiodio.exception.*;
import br.com.lucasbertoloto.desafiodio.model.Client;

public abstract class Account {
    protected static long IDENTIFICATION;
    protected static final int AGENCY = 1;
    private final long identification;
    protected Client client;
    protected Double balance;

    protected Account() {
        identification = IDENTIFICATION++;
        balance = 0D;
        this.client = null;
    }

    public long getIdentification() {
        return identification;
    }

    public Client getClient() {
        return client;
    }

    public Double getBalance() {
        return balance;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void deposit(Double value) throws NoValueException, NegativeValueException {
        int i = value.compareTo(0D);
        if (i == 0)
            throw new NoValueException();
        else if (i < 0)
            throw new NegativeValueException();
        else {
            balance = balance + value;
        }
    }

    public void withdraw(Double value) throws NoValueException, NegativeValueException, InsufficientBalanceException {
        int i = value.compareTo(0D);
        if (i == 0)
            throw new NoValueException();
        else if (i < 0)
            throw new NegativeValueException();
        else {
            int j = value.compareTo(balance);
            if(j > 0)
                throw new InsufficientBalanceException(this, value);
            else {
                balance = balance - value;
            }
        }
    }
}
