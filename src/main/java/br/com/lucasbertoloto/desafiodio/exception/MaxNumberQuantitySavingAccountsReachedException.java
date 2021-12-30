package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.Client;

public class MaxNumberQuantitySavingAccountsReachedException extends Exception{
    private final Client client;

    public MaxNumberQuantitySavingAccountsReachedException(Client client) {
        super();
        this.client = client;
    }

    @Override
    public String getMessage() {
        return "Max quantity of saving accounts to this client was reached: " + client.getMaxSavingAccounts();
    }
}
