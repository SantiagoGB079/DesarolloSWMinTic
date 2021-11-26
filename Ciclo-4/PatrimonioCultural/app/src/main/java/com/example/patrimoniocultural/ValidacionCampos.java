package com.example.patrimoniocultural;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionCampos {

    public boolean formRegistros(String nombreLugar, String tipoPatrimonio, String keyWords,
                                 String keyTag, String ubicacion) {
        System.out.println("NOMBRE "+nombreLugar);

        Pattern pattern = Pattern.compile("^[a-zA-Z]{3}");
        Matcher matcher = pattern.matcher(nombreLugar);


        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }

    }
}
