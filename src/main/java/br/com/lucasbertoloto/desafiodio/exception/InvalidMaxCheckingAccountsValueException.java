package br.com.lucasbertoloto.desafiodio.exception;

public class InvalidMaxCheckingAccountsValueException extends Exception {
    private final int maxAccounts;
    private final int maxSavingAccounts;
    private final int maxCheckingAccounts;
    public InvalidMaxCheckingAccountsValueException(int maxAccounts, int maxSavingAccounts, int maxCheckingAccounts) {
        super();
        this.maxAccounts = maxAccounts;
        this.maxCheckingAccounts = maxCheckingAccounts;
        this.maxSavingAccounts = maxSavingAccounts;
    }

    @Override
    public String getMessage() {
        return "Invalid value of max checking accounts: " + maxCheckingAccounts + "\n" +
                "Max saving accounts value must be equal or greater than " + (maxAccounts - maxSavingAccounts) + ".";
    }
}
