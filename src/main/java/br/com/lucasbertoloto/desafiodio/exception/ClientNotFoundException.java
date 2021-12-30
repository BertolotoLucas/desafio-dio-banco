package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.Client;

public class ClientNotFoundException extends Exception {
    private final Client client;

    public ClientNotFoundException(Client client) {
        super();
        this.client = client;
    }

    @Override
    public String getMessage() {
        return "Client with identification " + client.getIdentification() + " was not found.";
    }
}
