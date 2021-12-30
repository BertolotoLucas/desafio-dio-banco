package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.Client;

public class MaxNumberQuantityAccountsReachedException extends Exception{
    private final Client client;

    public MaxNumberQuantityAccountsReachedException(Client client) {
        super();
        this.client = client;
    }

    @Override
    public String getMessage() {
        return "Max quantity of accounts to this client was reached: " + client.getMaxAccounts();
    }
}
