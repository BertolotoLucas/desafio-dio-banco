package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.Client;
import br.com.lucasbertoloto.desafiodio.model.account.Account;

public class AccountWithAnotherClientException extends Exception {
    private final Client client;
    private final Account account;

    public AccountWithAnotherClientException(Client client, Account account) {
        super();
        this.client = client;
        this.account = account;
    }

    @Override
    public String getMessage() {
        return "The account belongs to another client: \n" +
                "Account owner: " + account.getClient().getName() + "\n" +
                "Client name: " + client.getName();
    }
}
