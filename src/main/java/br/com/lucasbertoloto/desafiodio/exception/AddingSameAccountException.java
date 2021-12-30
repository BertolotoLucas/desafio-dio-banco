package br.com.lucasbertoloto.desafiodio.exception;

public class AddingSameAccountException extends Exception {
    @Override
    public String getMessage() {
        return "The client already has this account";
    }
}
