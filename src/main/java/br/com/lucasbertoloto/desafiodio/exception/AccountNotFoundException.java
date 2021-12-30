package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.account.Account;

public class AccountNotFoundException extends Exception{
    private final Account account;

    public AccountNotFoundException(Account account) {
        super();
        this.account = account;
    }

    @Override
    public String getMessage() {
        return "The account with identification " + this.account.getIdentification() + " was not found.";
    }
}
