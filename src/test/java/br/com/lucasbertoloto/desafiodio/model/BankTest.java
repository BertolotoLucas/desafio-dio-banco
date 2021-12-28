package br.com.lucasbertoloto.desafiodio.model;

import br.com.lucasbertoloto.desafiodio.model.account.Account;
import br.com.lucasbertoloto.desafiodio.model.account.CheckingAccount;
import br.com.lucasbertoloto.desafiodio.model.account.SavingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BankTest {

    private Bank bank;

    @BeforeEach
    void initialize(){
        bank = new Bank("MyBank");
        Client c1 = new Client("Maicon");
        Client c2 = new Client("Luiz");
        Client c3 = new Client("Daniel");

        Account ac1 = new SavingAccount(c1);
        Account ac2 = new CheckingAccount(c2);
        Account ac3 = new SavingAccount(c3);
        Account ac4 = new CheckingAccount(c3);

        ac1.deposit(100D);
        ac2.deposit(100D);
        ac3.deposit(100D);
        ac4.deposit(100D);

        bank.addClient(c1);
        bank.addClient(c2);
        bank.addClient(c3);
    }

    @Test
    void shouldReturnAListOfAllClients(){
        List<Client> clientList = new ArrayList<Client>();

        Client c1 = new Client("Maicon");
        Client c2 = new Client("Luiz");
        Client c3 = new Client("Daniel");

        clientList.add(c1);
        clientList.add(c2);
        clientList.add(c3);

        Assertions.assertTrue(bank.getClients().equals(clientList));
    }

    @Test
    void shouldReturnAListOfAllAccounts(){
        Client c1 = new Client("Maicon");
        Client c2 = new Client("Luiz");
        Client c3 = new Client("Daniel");

        Account ac1 = new SavingAccount(c1);
        Account ac2 = new CheckingAccount(c2);
        Account ac3 = new SavingAccount(c3);
        Account ac4 = new CheckingAccount(c3);

        ac1.deposit(100D);
        ac2.deposit(100D);
        ac3.deposit(100D);
        ac4.deposit(100D);

        List<Account> accountList = new ArrayList<Account>();
        accountList.add(ac1);
        accountList.add(ac2);
        accountList.add(ac3);
        accountList.add(ac4);

        Assertions.assertTrue(bank.getAllAccounts().equals(accountList));
    }

    @Test
    void shouldReturnTheValueOfAllDepositedMoney(){
        Assertions.assertEquals(400D, bank.getAllDepositedMoney());
        List<Account> accountList = bank.getAllAccounts();
        accountList.get(0).withdraw(100D);
        Assertions.assertEquals(300D, bank.getAllDepositedMoney());
    }

}
