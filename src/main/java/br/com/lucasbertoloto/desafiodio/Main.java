package br.com.lucasbertoloto.desafiodio;

import br.com.lucasbertoloto.desafiodio.model.Bank;
import br.com.lucasbertoloto.desafiodio.model.Client;
import br.com.lucasbertoloto.desafiodio.model.account.Account;
import br.com.lucasbertoloto.desafiodio.model.account.CheckingAccount;
import br.com.lucasbertoloto.desafiodio.model.account.SavingAccount;

public class Main {
    public static void main(String[] args) throws Exception{
        Bank myBank = new Bank("MyBank");
        Client c1 = new Client("Lucas");
        Account ac1 = new SavingAccount();
        CheckingAccount ac2 = new CheckingAccount(7.50D);
        ac1.deposit(10D);
        ac2.deposit(500D);
        ac2.transfer(250D, ac1);
        c1.addAccount(ac1);
        c1.addAccount(ac2);
        myBank.addClient(c1);

        Client c2 = new Client("Fabricio");
        Account ac3 = new SavingAccount();
        CheckingAccount ac4 = new CheckingAccount(7.50D);
        ac3.deposit(1000D);
        ac4.deposit(90000D);
        ac4.transfer(50000D, ac3);
        c2.addAccount(ac3);
        c2.addAccount(ac4);
        myBank.addClient(c2);

        System.out.println("Information of " + myBank.getName() + ":");
        System.out.println(myBank);
        System.out.println("Information of all clients in " + myBank.getName() + ":");
        myBank.getClients().forEach(System.out::println);
        System.out.println("Information of all accounts in " + myBank.getName() + ":");
        myBank.getAllAccounts().forEach(System.out::println);
    }
}
