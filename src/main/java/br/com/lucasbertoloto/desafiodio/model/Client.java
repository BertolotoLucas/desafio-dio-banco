package br.com.lucasbertoloto.desafiodio.model;

import br.com.lucasbertoloto.desafiodio.exception.*;
import br.com.lucasbertoloto.desafiodio.model.account.Account;
import br.com.lucasbertoloto.desafiodio.model.account.CheckingAccount;
import br.com.lucasbertoloto.desafiodio.model.account.SavingAccount;
import java.util.ArrayList;
import java.util.List;

public class Client {
    protected static long IDENTIFICATION;
    private final long identification;
    private Bank bank;
    private String name;
    private final List<Account> accounts;

    public Client(String name) {
        this.name = name;
        identification = IDENTIFICATION++;
        accounts = new ArrayList<>();
    }

    public long getIdentification() {
        return identification;
    }

    public Bank getBank() {
        return bank;
    }

    public String getName() {
        return name;
    }


    public List<Account> getAccounts() {
        return accounts;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAccount(Account account) throws MaxNumberQuantityAccountsReachedException,
            MaxNumberQuantitySavingAccountsReachedException, MaxNumberQuantityCheckingAccountsReachedException,
            AddingSameAccountException, AccountWithAnotherClientException {
        if (accounts.size() >= 2)
            throw new MaxNumberQuantityAccountsReachedException();
        else {
            for (Account ac : accounts) {
                if (account.equals(ac))
                    throw new AddingSameAccountException();
                else if (ac instanceof SavingAccount && account instanceof SavingAccount)
                    throw new MaxNumberQuantitySavingAccountsReachedException();
                else if (ac instanceof CheckingAccount && account instanceof CheckingAccount)
                    throw new MaxNumberQuantityCheckingAccountsReachedException();
            }
            if (!(account.getClient() == null))
                if (!account.getClient().equals(this))
                    throw new AccountWithAnotherClientException();
            accounts.add(account);
            account.setClient(this);
        }
    }

    public Account removeAccount(Account account) throws NoAccountException, AccountNotFoundException {
        if (accounts.isEmpty())
            throw new NoAccountException();
        else {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).equals(account))
                    return accounts.remove(i);
            }
            throw new AccountNotFoundException();
        }
    }
}
