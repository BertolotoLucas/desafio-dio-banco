package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.Client;

public class InvalidMaxAccountsValueException extends Exception {
    private final int maxAccounts;
    private final int maxSavingAccounts;
    private final int maxCheckingAccounts;

    public InvalidMaxAccountsValueException(Client client) {
        super();
        this.maxAccounts = client.getMaxAccounts();
        this.maxCheckingAccounts = client.getMaxCheckingAccounts();
        this.maxSavingAccounts = client.getMaxSavingAccounts();
    }

    @Override
    public String getMessage() {
        return "Invalid value of max accounts: " + maxAccounts + "\n" +
                "Max accounts value must be equal or smaller than " + maxSavingAccounts + maxCheckingAccounts + ".";
    }
}
