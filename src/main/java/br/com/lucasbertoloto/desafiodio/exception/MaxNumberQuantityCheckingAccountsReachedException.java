package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.Client;

public class MaxNumberQuantityCheckingAccountsReachedException extends Exception{
    private final Client client;

    public MaxNumberQuantityCheckingAccountsReachedException(Client client) {
        super();
        this.client = client;
    }

    @Override
    public String getMessage() {
        return "Max quantity of checking accounts to this client was reached: " + client.getMaxCheckingAccounts();
    }
}
