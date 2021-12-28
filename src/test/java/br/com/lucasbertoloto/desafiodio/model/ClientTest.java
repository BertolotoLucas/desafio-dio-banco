package br.com.lucasbertoloto.desafiodio.model;

import br.com.lucasbertoloto.desafiodio.exception.*;
import br.com.lucasbertoloto.desafiodio.model.account.Account;
import br.com.lucasbertoloto.desafiodio.model.account.CheckingAccount;
import br.com.lucasbertoloto.desafiodio.model.account.SavingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {
    private Client client;
    private Account ac1;
    private Account ac2;

    @BeforeEach
    void initialize() throws MaxNumberQuantityCheckingAccountsReachedException,
            MaxNumberQuantityAccountsReachedException, MaxNumberQuantitySavingAccountsReachedException,
            AddingSameAccountException, AccountWithAnotherClientException {
        client = new Client("Maycon");
        ac1 = new SavingAccount(client);
        ac2 = new CheckingAccount(client);
    }

    @Test
    void shouldReturnAllAccountsOfThisClient(){
        List<Account> accountList = new ArrayList<>();
        accountList.add(ac1);
        accountList.add(ac2);
        Assertions.assertTrue(client.getAccounts().equals(accountList));
    }

    @Test
    void shouldReturnAnAccountWithAnotherClientException(){
        Client c1 = new Client("Jose");
        Assertions.assertThrows(AccountWithAnotherClientException.class, () -> c1.addAccount(ac1));
    }

    @Test
    void shouldRemoveAnAccountOfThisClient() throws NoAccountException, AccountNotFoundException {
        List<Account> accounts = new ArrayList<>(client.getAccounts());
        Account account = accounts.remove(0);
        System.out.println(account);
        System.out.println(ac1);
        Account removed = client.removeAccount(ac1);
        System.out.println(removed);
        Assertions.assertEquals(account,removed);
        Assertions.assertEquals(accounts,client.getAccounts());

        account = accounts.remove(0);
        removed = client.removeAccount(ac2);
        Assertions.assertEquals(account,removed);
        Assertions.assertEquals(accounts,client.getAccounts());
        Assertions.assertTrue(client.getAccounts().isEmpty());
    }

    @Test
    void shouldReturnANoAccountException(){
        client = new Client("Julio");
        Assertions.assertThrows(NoAccountException.class, () -> client.removeAccount(ac1));
    }

    @Test
    void shouldReturnAnAccountNotFoundException() throws MaxNumberQuantityCheckingAccountsReachedException,
            MaxNumberQuantityAccountsReachedException, MaxNumberQuantitySavingAccountsReachedException,
            AddingSameAccountException, AccountWithAnotherClientException {
        Account account = new CheckingAccount(new Client("Julio"));
        Assertions.assertThrows(AccountNotFoundException.class, () -> client.removeAccount(account));
    }

}
