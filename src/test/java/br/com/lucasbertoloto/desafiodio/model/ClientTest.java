package br.com.lucasbertoloto.desafiodio.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ClientTest {
    private Client client;

    @BeforeEach
    void initialize(){
        client = new Client("Maycon");
        Account ac1 = new SavingAccount(client);
        Account ac2 = new CheckingAccount(client);

        List<Account> accountList = new ArrayList<Account>();
        accountList.add(ac1);
        accountList.add(ac2);
    }

    @Test
    void shouldReturnAllAccountsOfThisClient() {
        Account ac1 = new SavingAccount(client);
        Account ac2 = new CheckingAccount(client);

        List<Account> accountList = new ArrayList<Account>();
        accountList.add(ac1);
        accountList.add(ac2);

        Assertions.assertTrue(client.getAccounts().equals(accountList));
    }

}
