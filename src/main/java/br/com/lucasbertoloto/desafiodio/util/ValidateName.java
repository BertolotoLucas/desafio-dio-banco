package br.com.lucasbertoloto.desafiodio.util;

import br.com.lucasbertoloto.desafiodio.exception.InvalidNameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateName {
    public static void validate(String name) throws InvalidNameException {
        Pattern pattern = Pattern.compile(new String("^[a-zA-Z\\s]*$"));
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches())
            throw new InvalidNameException(name);
    }
}
