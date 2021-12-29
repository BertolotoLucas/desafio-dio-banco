package br.com.lucasbertoloto.desafiodio.model;

import br.com.lucasbertoloto.desafiodio.exception.ClientAlreadyRegisteredException;
import br.com.lucasbertoloto.desafiodio.exception.ClientNotFoundException;
import br.com.lucasbertoloto.desafiodio.model.account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Bank {
    private static long IDENTIFICATION = 0;
    private final long identification;
    private String name;
    private final List<Client> clients;

    public Bank(String name) {
        this.name = name;
        identification = IDENTIFICATION++;
        clients = new ArrayList<>();
    }

    public long getIdentification() {
        return identification;
    }

    public String getName() {
        return name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addClient(Client client) throws ClientAlreadyRegisteredException {
        for (Client c : clients)
            if (c.equals(client))
                throw new ClientAlreadyRegisteredException();
        clients.add(client);
    }

    public void removeClient(Client client) throws ClientNotFoundException {
        for (Client c : clients)
            if (c.equals(client))
                clients.remove(client);
        throw new ClientNotFoundException();
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        for (Client c : clients)
            accounts.addAll(c.getAccounts());
        return accounts;
    }

    public Double getAllDepositedMoney() {
        List<Account> accounts = new ArrayList<>(getAllAccounts());
        Double total = 0D;
        for (Account ac : accounts)
            total += ac.getBalance();
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return identification == bank.identification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "identification=" + identification +
                ", name='" + name  +
                ", totalClients=" + clients.size() +
                ", totalAccounts=" + getAllAccounts().size() +
                ", totalMoneyDeposited=" + getAllDepositedMoney() +
                '}';
    }
}
