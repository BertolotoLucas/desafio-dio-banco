package br.com.lucasbertoloto.desafiodio.exception;

import br.com.lucasbertoloto.desafiodio.model.Client;

public class NoAccountException extends Exception {
    private final Client client;

    public NoAccountException(Client client) {
        super();
        this.client = client;
    }

    @Override
    public String getMessage() {
        return "The client with identification " + client.getIdentification() + " does not has any account yet.";
    }
}
