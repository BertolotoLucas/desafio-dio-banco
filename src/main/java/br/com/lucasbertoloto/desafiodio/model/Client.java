package br.com.lucasbertoloto.desafiodio.model;

import br.com.lucasbertoloto.desafiodio.exception.*;
import br.com.lucasbertoloto.desafiodio.model.account.Account;
import br.com.lucasbertoloto.desafiodio.model.account.CheckingAccount;
import br.com.lucasbertoloto.desafiodio.model.account.SavingAccount;
import br.com.lucasbertoloto.desafiodio.util.ValidateName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    protected static long IDENTIFICATION;
    private final long identification;
    private Bank bank;
    private String name;
    private final List<Account> accounts;
    private int maxAccounts;
    private int maxSavingAccounts;
    private int maxCheckingAccounts;

    public Client(String name) throws InvalidNameException {
        validateClientName(name);
        identification = IDENTIFICATION++;
        accounts = new ArrayList<>();
        maxAccounts = 2;
        maxCheckingAccounts = 1;
        maxSavingAccounts = 1;
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

    public int getMaxAccounts() {
        return maxAccounts;
    }

    public int getMaxSavingAccounts() {
        return maxSavingAccounts;
    }

    public int getMaxCheckingAccounts() {
        return maxCheckingAccounts;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setName(String name) throws InvalidNameException {
        validateClientName(name);
    }

    private void validateClientName(String name) throws InvalidNameException {
        name = name.trim();
        ValidateName.validate(name);
        this.name = name;
    }

    public void setMaxAccounts(int maxAccounts) throws NoValueException, NegativeValueException,
            InvalidMaxAccountsValueException {
        Integer maxAcc = maxAccounts;
        int i = maxAcc.compareTo(0);
        if (i == 0)
            throw new NoValueException();
        else if (i < 0)
            throw new NegativeValueException();
        else {
            if (maxAcc < maxSavingAccounts + maxCheckingAccounts)
                throw new InvalidMaxAccountsValueException(this);
            this.maxAccounts = maxAccounts;
        }
    }

    public void setMaxSavingAccounts(int maxSavingAccounts) throws NoValueException, NegativeValueException,
            InvalidMaxSavingAccountsValueException {
        Integer maxAcc = maxSavingAccounts;
        int i = maxAcc.compareTo(0);
        if (i == 0)
            throw new NoValueException();
        else if (i < 0)
            throw new NegativeValueException();
        else {
            if (maxSavingAccounts > maxAccounts - maxCheckingAccounts)
                throw new InvalidMaxSavingAccountsValueException(this);
            this.maxSavingAccounts = maxSavingAccounts;
        }
    }

    public void setMaxCheckingAccounts(int maxCheckingAccounts) throws NoValueException, NegativeValueException,
            InvalidMaxCheckingAccountsValueException {
        Integer maxAcc = maxCheckingAccounts;
        int i = maxAcc.compareTo(0);
        if (i == 0)
            throw new NoValueException();
        else if (i < 0)
            throw new NegativeValueException();
        else {
            if (maxCheckingAccounts > maxAccounts - maxSavingAccounts)
                throw new InvalidMaxCheckingAccountsValueException(maxAccounts,maxSavingAccounts,maxCheckingAccounts);
            this.maxCheckingAccounts = maxCheckingAccounts;
        }
    }

    public void addAccount(Account account) throws MaxNumberQuantityAccountsReachedException,
            MaxNumberQuantitySavingAccountsReachedException, MaxNumberQuantityCheckingAccountsReachedException,
            AddingSameAccountException, AccountWithAnotherClientException {
        if (accounts.size() >= maxAccounts)
            throw new MaxNumberQuantityAccountsReachedException(this);
        else {
            int qntSavingAccount = 0;
            int qntCheckingAccount = 0;
            for (Account ac : accounts) {
                if (account.equals(ac))
                    throw new AddingSameAccountException();
                else if (ac instanceof SavingAccount) {
                    qntSavingAccount++;
                    if (qntSavingAccount >= maxSavingAccounts && account instanceof SavingAccount)
                        throw new MaxNumberQuantitySavingAccountsReachedException(this);
                }
                else if (ac instanceof CheckingAccount) {
                    qntCheckingAccount++;
                    if (qntCheckingAccount >= maxCheckingAccounts && account instanceof CheckingAccount)
                        throw new MaxNumberQuantityCheckingAccountsReachedException(this);
                }
            }
            if (!(account.getClient() == null))
                if (!account.getClient().equals(this))
                    throw new AccountWithAnotherClientException(this, account);
            accounts.add(account);
            account.setClient(this);
        }
    }

    public Account removeAccount(Account account) throws NoAccountException, AccountNotFoundException {
        if (accounts.isEmpty())
            throw new NoAccountException(this);
        else {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).equals(account)) {
                    accounts.get(i).setClient(null);
                    return accounts.remove(i);
                }
            }
            throw new AccountNotFoundException(account);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return identification == client.identification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification);
    }

    @Override
    public String toString() {
        return "Client{" +
                "identification=" + identification +
                ", bank=" + bank.getName() +
                ", name='" + name + '\'' +
                ", maxAccounts=" + maxAccounts +
                ", maxSavingAccounts=" + maxSavingAccounts +
                ", maxCheckingAccounts=" + maxCheckingAccounts +
                '}';
    }
}
