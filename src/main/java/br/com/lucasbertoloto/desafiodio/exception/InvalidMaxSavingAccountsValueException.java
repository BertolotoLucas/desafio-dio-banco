package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.Client;

public class InvalidMaxSavingAccountsValueException extends Exception {
    private final int maxAccounts;
    private final int maxSavingAccounts;
    private final int maxCheckingAccounts;

    public InvalidMaxSavingAccountsValueException(Client client) {
        super();
        this.maxAccounts = client.getMaxAccounts();
        this.maxCheckingAccounts = client.getMaxCheckingAccounts();
        this.maxSavingAccounts = client.getMaxSavingAccounts();
    }

    @Override
    public String getMessage() {
        return "Invalid value of max saving accounts: " + maxSavingAccounts + "\n" +
                "Max saving accounts value must be equal or greater than " + (maxAccounts - maxCheckingAccounts) + ".";
    }
}
