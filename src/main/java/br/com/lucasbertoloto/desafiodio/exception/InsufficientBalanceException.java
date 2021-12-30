package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.account.Account;

public class InsufficientBalanceException extends Exception{
    private final Account account;
    private final Double value;

    public InsufficientBalanceException(Account account, Double value) {
        super();
        this.account = account;
        this.value = value;
    }

    @Override
    public String getMessage() {
        return "The value is greater than the balance in the account: \n" +
                "Balance at the account: " + account.getBalance() + "\n" +
                "Value : " + value.toString();
    }
}
