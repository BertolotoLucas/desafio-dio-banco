package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.Bank;
import br.com.lucasbertoloto.desafiodio.model.Client;

public class ClientAlreadyRegisteredException extends Exception {
    private final Bank bank;
    private final Client client;

    public ClientAlreadyRegisteredException(Bank bank, Client client) {
        super();
        this.bank = bank;
        this.client = client;
    }

    @Override
    public String getMessage() {
        return "Client with identification " + client.getIdentification() + " is already registered in " +
                "the bank with name: " + bank.getName() + ".";
    }
}
