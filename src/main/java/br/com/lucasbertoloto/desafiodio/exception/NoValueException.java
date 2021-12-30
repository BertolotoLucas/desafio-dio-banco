package br.com.lucasbertoloto.desafiodio.exception;

public class NoValueException extends Exception{
    @Override
    public String getMessage() {
        return "Value must not be zero.";
    }
}
