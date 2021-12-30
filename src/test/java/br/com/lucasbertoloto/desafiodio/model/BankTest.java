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

public class BankTest {

    private Bank bank;
    private Client c1;
    private Client c2;
    private Client c3;
    private Account ac1;
    private Account ac2;
    private Account ac3;
    private Account ac4;

    @BeforeEach
    void initialize() throws InvalidNameException, NoValueException, NegativeValueException,
            MaxNumberQuantityCheckingAccountsReachedException, MaxNumberQuantityAccountsReachedException,
            MaxNumberQuantitySavingAccountsReachedException, AddingSameAccountException,
            AccountWithAnotherClientException, ClientAlreadyRegisteredException {
        bank = new Bank("MyBank");
        c1 = new Client("Maicon");
        c2 = new Client("Luiz");
        c3 = new Client("Daniel");

        ac1 = new SavingAccount();
        ac2 = new CheckingAccount(10D);
        ac3 = new SavingAccount();
        ac4 = new CheckingAccount(10D);

        c1.addAccount(ac1);
        c2.addAccount(ac2);
        c3.addAccount(ac3);
        c3.addAccount(ac4);

        ac1.deposit(100D);
        ac2.deposit(100D);
        ac3.deposit(100D);
        ac4.deposit(100D);

        bank.addClient(c1);
        bank.addClient(c2);
        bank.addClient(c3);
    }

    @Test
    void shouldChangeTheNameOfTheBank() throws InvalidNameException {
        bank.setName("MySecondBank");
        Assertions.assertEquals("MySecondBank", bank.getName());
    }

    @Test
    void shouldReturnAListOfAllClients(){
        List<Client> clientList = new ArrayList<>();

        clientList.add(c1);
        clientList.add(c2);
        clientList.add(c3);

        Assertions.assertEquals(bank.getClients(), clientList);
    }

    @Test
    void shouldReturnAListOfAllAccounts(){

        List<Account> accountList = new ArrayList<>();
        accountList.add(ac1);
        accountList.add(ac2);
        accountList.add(ac3);
        accountList.add(ac4);

        Assertions.assertEquals(bank.getAllAccounts(), accountList);
    }

    @Test
    void shouldReturnTheValueOfAllDepositedMoney() throws NoValueException, NegativeValueException,
            InsufficientBalanceException {
        Assertions.assertEquals(400D, bank.getAllDepositedMoney());
        List<Account> accountList = bank.getAllAccounts();
        accountList.get(0).withdraw(100D);
        Assertions.assertEquals(300D, bank.getAllDepositedMoney());
    }

    @Test
    void shouldReturnInvalidNameException() {
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas/bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas!bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas@bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas#bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas$bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas%bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas¨bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas&bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas*bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas(bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas)bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas-bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas_bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas+bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas=bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas[bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas]bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas{bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas}bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas^bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas~bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas,bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas.bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas<bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas>bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas;bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas:bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas?bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas|bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas\\bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas'bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas\"bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas1bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucasºbertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucasªbertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas°bertoloto"));
        Assertions.assertThrows(InvalidNameException.class, () -> bank.setName("Lucas\"bertoloto"));
    }

    @Test
    void shouldReturnClientAlreadyRegisteredException() {
        Assertions.assertThrows(ClientAlreadyRegisteredException.class, () -> bank.addClient(c3));
    }

    @Test
    void shouldReturnClientNotFountException() throws InvalidNameException {
        Client victim = new Client("Ronaldo");
        Assertions.assertThrows(ClientNotFoundException.class, () -> bank.removeClient(victim));
    }

}
