package br.com.lucasbertoloto.desafiodio.model.account;

import br.com.lucasbertoloto.desafiodio.model.Client;
import br.com.lucasbertoloto.desafiodio.exception.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {
    private Client client;
    private Account ac;

    @BeforeEach
    void initialize() throws MaxNumberQuantityCheckingAccountsReachedException,
            MaxNumberQuantityAccountsReachedException, MaxNumberQuantitySavingAccountsReachedException,
            AddingSameAccountException, AccountWithAnotherClientException {
        client = new Client("Maycon");
        ac = new CheckingAccount(client);
    }

    @Test
    void shouldIncreaseTheAccountBalance() throws NoValueException, NegativeValueException {
        ac.deposit(100D);
        Assertions.assertEquals(100D, ac.getBalance());
    }

    @Test
    void shouldDecreaseTheAccountBalance() throws NoValueException, NegativeValueException, InsufficientBalanceException {
        ac.deposit(100D);
        ac.withdraw(50D);
        Assertions.assertEquals(50D, ac.getBalance());
    }

    @Test
    void shouldReturnNegativeValueException() throws NoValueException, NegativeValueException {
        ac.deposit(100D);

        Assertions.assertThrows(NegativeValueException.class,
                () -> ac.deposit(-100D));

        Assertions.assertThrows(NegativeValueException.class,
                () -> ac.withdraw(-100D));
    }

    @Test
    void shouldReturnNoValueException() {
        Assertions.assertThrows(NoValueException.class,
                () -> ac.deposit(0D));

        Assertions.assertThrows(NoValueException.class,
                () -> ac.withdraw(0D));
    }

    @Test
    void shouldReturnInsufficientBalanceException() {
        Assertions.assertThrows(InsufficientBalanceException.class,
                () -> ac.withdraw(100D));
    }

    @Test
    void shouldReturnAMaxNumberQuantityAccountsReachedException() throws AccountWithAnotherClientException,
            MaxNumberQuantityCheckingAccountsReachedException, MaxNumberQuantityAccountsReachedException,
            MaxNumberQuantitySavingAccountsReachedException, AddingSameAccountException {

        new SavingAccount(client);
        Assertions.assertThrows(MaxNumberQuantityAccountsReachedException.class,
                () -> new CheckingAccount(client));
    }

    @Test
    void shouldReturnAMaxNumberQuantityCheckingAccountsReachedException() throws
            MaxNumberQuantityCheckingAccountsReachedException,
            MaxNumberQuantityAccountsReachedException, MaxNumberQuantitySavingAccountsReachedException,
            AddingSameAccountException, AccountWithAnotherClientException {
        client = new Client("Maycon");
        Account ac1 = new CheckingAccount(client);
        Assertions.assertThrows(MaxNumberQuantityCheckingAccountsReachedException.class,
                () -> new CheckingAccount(client));
    }

    @Test
    void shouldReturnAnAddingSameAccountException() throws MaxNumberQuantityCheckingAccountsReachedException,
            MaxNumberQuantityAccountsReachedException, MaxNumberQuantitySavingAccountsReachedException,
            AddingSameAccountException, AccountWithAnotherClientException {
        client = new Client("Maycon");
        Account ac1 = new CheckingAccount(client);
        Assertions.assertThrows(AddingSameAccountException.class, () -> client.addAccount(ac1));
    }
}
