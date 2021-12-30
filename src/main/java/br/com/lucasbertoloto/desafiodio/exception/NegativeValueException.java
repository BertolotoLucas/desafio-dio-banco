package br.com.lucasbertoloto.desafiodio.exception;

public class NegativeValueException extends Exception{
    @Override
    public String getMessage() {
        return "Value must be positive.";
    }
}
