package br.com.lucasbertoloto.desafiodio.model.account;

import br.com.lucasbertoloto.desafiodio.exception.InsufficientBalanceException;
import br.com.lucasbertoloto.desafiodio.exception.NegativeValueException;
import br.com.lucasbertoloto.desafiodio.exception.NoValueException;
import br.com.lucasbertoloto.desafiodio.model.Client;

import java.util.Objects;

public abstract class Account {
    protected static long IDENTIFICATION;
    protected static final int AGENCY = 1;
    protected Client client;
    protected Double balance;

    public static long getIDENTIFICATION() {
        return IDENTIFICATION;
    }

    public Client getClient() {
        return client;
    }

    public Double getBalance() {
        return balance;
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

    public Double withdraw(Double value) throws NoValueException, NegativeValueException, InsufficientBalanceException {
        int i = value.compareTo(0D);
        if (i == 0)
            throw new NoValueException();
        else if (i < 0)
            throw new NegativeValueException();
        else {
            int j = value.compareTo(balance);
            if(j > 0)
                throw new InsufficientBalanceException();
            else {
                balance = balance - value;
                return value;
            }
        }
    }
}
