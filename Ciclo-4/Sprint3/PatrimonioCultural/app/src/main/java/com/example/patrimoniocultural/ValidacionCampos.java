package com.example.patrimoniocultural;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionCampos {

    public boolean formRegistros(String nombreLugar, String tipoPatrimonio, String keyWords,
                                 String keyTag, String ubicacion) {

        System.out.println(nombreLugar+"\n"+tipoPatrimonio+"\n"+keyWords+"\n"+keyTag+"\n"+ubicacion);

        Pattern pattern = Pattern.compile("^[a-zA-Z ]{3,30}");
        Pattern patternEtiq = Pattern.compile("^[a-zA-Z 0-9]{3,30}");
        Pattern patternPalabras = Pattern.compile("^([a-zA-Z+,]){2,100}");

        Matcher matcher = pattern.matcher(nombreLugar);
        Matcher matPat = pattern.matcher(tipoPatrimonio);
        Matcher matKW = patternPalabras.matcher(keyWords);
        Matcher matKT = patternEtiq.matcher(keyTag);
        Matcher matUbicacion = pattern.matcher(ubicacion);

        if (matcher.matches() && matPat.matches() && matKT.matches() && matKW.matches()
                && matUbicacion.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean formBusqueda(String keyWords) {

        Pattern pattern = Pattern.compile("^([a-zA-Z+,]){2,100}");
        Matcher matcher = pattern.matcher(keyWords);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean formEtiqueta(String keyTag) {

        Pattern pattern = Pattern.compile("^[a-zA-Z]{2,100}");
        Matcher matcher = pattern.matcher(keyTag);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }

    }
}
