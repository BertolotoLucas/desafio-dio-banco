package br.com.lucasbertoloto.desafiodio.exception;

public class InvalidNameException extends Exception{
    private final String name;
    public InvalidNameException(String name) {
        super();
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "Invalid name: " + name + "\n" +
                "Name can only have letters and space";
    }
}
