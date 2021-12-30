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
    void initialize() throws InvalidNameException, MaxNumberQuantityCheckingAccountsReachedException,
            MaxNumberQuantityAccountsReachedException, MaxNumberQuantitySavingAccountsReachedException,
            AddingSameAccountException, AccountWithAnotherClientException {
        client = new Client("Maycon");
        ac1 = new SavingAccount();
        ac2 = new CheckingAccount(10D);
        client.addAccount(ac1);
        client.addAccount(ac2);
    }

    @Test
    void shouldReturnAllAccountsOfThisClient(){
        List<Account> accountList = new ArrayList<>();
        accountList.add(ac1);
        accountList.add(ac2);
        Assertions.assertEquals(client.getAccounts(), accountList);
    }

    @Test
    void shouldChangeTheNameOfTheClient() throws InvalidNameException {
        client.setName("Silvio");
        Assertions.assertEquals("Silvio", client.getName());
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
    void shouldChangeMaxAccountValueToThree() throws NoValueException, NegativeValueException,
            InvalidMaxAccountsValueException {
        client.setMaxAccounts(3);
        Assertions.assertEquals(3, client.getMaxAccounts());
    }

    @Test
    void shouldChangeMaxSavingAccountValueToTwo() throws NoValueException, NegativeValueException,
            InvalidMaxAccountsValueException, InvalidMaxSavingAccountsValueException {
        client.setMaxAccounts(3);
        client.setMaxSavingAccounts(2);
        Assertions.assertEquals(2, client.getMaxSavingAccounts());
    }

    @Test
    void shouldChangeMaxCheckingAccountValueToTwo() throws NoValueException, NegativeValueException,
            InvalidMaxAccountsValueException, InvalidMaxCheckingAccountsValueException {
        client.setMaxAccounts(3);
        client.setMaxCheckingAccounts(2);
        Assertions.assertEquals(2, client.getMaxCheckingAccounts());
    }

    @Test
    void shouldReturnInvalidNameException() {
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas/bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas!bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas@bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas#bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas$bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas%bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas¨bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas&bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas*bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas(bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas)bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas-bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas_bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas+bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas=bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas[bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas]bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas{bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas}bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas^bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas~bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas,bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas.bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas<bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas>bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas;bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas:bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas?bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas|bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas\\bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas'bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas\"bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas1bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucasºbertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucasªbertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas°bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> client.setName("Lucas\"bertoloto"));
    }

    @Test
    void shouldReturnANoAccountException() throws InvalidNameException {
        client = new Client("Julio");
        Assertions.assertThrows(NoAccountException.class, () -> client.removeAccount(ac1));
    }

    @Test
    void shouldReturnAnAccountNotFoundException(){
        Account account = new CheckingAccount(10D);
        Assertions.assertThrows(AccountNotFoundException.class, () -> client.removeAccount(account));
    }

    @Test
    void shouldReturnAnAccountWithAnotherClientException() throws InvalidNameException {
        Client c1 = new Client("Jose");
        Assertions.assertThrows(AccountWithAnotherClientException.class, () -> c1.addAccount(ac1));
    }

    @Test
    void shouldReturnInvalidMaxAccountsValueException(){
        Assertions.assertThrows(InvalidMaxAccountsValueException.class, () -> client.setMaxAccounts(1));
    }

    @Test
    void shouldReturnInvalidMaxSavingAccountsValueException(){
        Assertions.assertThrows(InvalidMaxSavingAccountsValueException.class, () -> client.setMaxSavingAccounts(2));
    }

    @Test
    void shouldReturnInvalidMaxCheckingAccountsValueException(){
        Assertions.assertThrows(InvalidMaxCheckingAccountsValueException.class, () -> client.setMaxCheckingAccounts(2));
    }

}
