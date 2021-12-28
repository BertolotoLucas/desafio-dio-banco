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
    void initialize() {
        client = new Client("Maycon");
        ac = new CheckingAccount(client);
    }

    @Test
    void shouldIncreaseTheAccountBalance(){
        ac.deposit(100D);
        Assertions.assertEquals(100D, ac.getBalance());
    }

    @Test
    void shouldDecreaseTheAccountBalance(){
        ac.deposit(100D);
        ac.withdraw(50D);
        Assertions.assertEquals(50D, ac.getBalance());
    }

    @Test
    void shouldReturnNegativeValueException() {
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
    void shouldReturnInsufficientBalance() {
        Assertions.assertThrows(InsufficientBalanceException.class,
                () -> ac.withdraw(100D));
    }

    @Test
    void shouldReturnAMaxNumberQuantityAccountsReachedException() {
        Assertions.assertThrows(MaxNumberQuantityAccountsReachedException.class,
                () -> new CheckingAccount(client));

        client = new Client("Maycon");
        Account ac1 = new CheckingAccount(client);
        Assertions.assertThrows(MaxNumberQuantityCheckingAccountsReachedException.class,
                () -> new CheckingAccount(client));
    }
}
