package com.example.patrimoniocultural;

public class DataProcess {

    public String generadorEtiqueta(String nombreLugar, String nombrePatrimonio) {

        String etiqueta;

        if (nombreLugar.isEmpty() || nombrePatrimonio.isEmpty()) {
            etiqueta = "Tiene campos vacíos";
        } else {
            if (nombrePatrimonio.contains("Inmueble")) {
                nombrePatrimonio = "PI";
            } else {
                nombrePatrimonio = "PM";
            }
            etiqueta = nombreLugar.toUpperCase().substring(0, 3) +
                    nombrePatrimonio.toUpperCase().substring(0, 2) + 1002;
        }

        return etiqueta;
    }

    public int contadorKeyWord(String keyWords) {

        String[] cantPalabras;
        cantPalabras = keyWords.split(",");

        System.out.println("CANTIDAD DE PALABRAS: " + cantPalabras.length);

        return cantPalabras.length;

    }
}
