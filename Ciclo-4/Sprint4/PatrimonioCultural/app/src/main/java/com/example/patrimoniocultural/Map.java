package com.example.patrimoniocultural;

import java.text.DecimalFormat;

public class Map {

    public boolean coordenadasLimites(String ubicacion) {

        String ubicaciones[] = ubicacion.split(",");

        double latitud = Double.parseDouble(ubicaciones[0]);
        double longitud = Double.parseDouble(ubicaciones[1]);

        if (latitud > 12.4466 || latitud < 4.2083) {
            return false;
        } else if (longitud < -81.8501 || longitud > -66.8483) {
            return false;
        }
        return true;
    }

    public String convertirUbicacion(String ubicacion) {

        String ubicaciones[] = ubicacion.split(",");

        double latitud = Double.parseDouble(ubicaciones[0]);
        double longitud = Double.parseDouble(ubicaciones[1]);
        DecimalFormat df = new DecimalFormat("#.000");
        DecimalFormat df2 = new DecimalFormat("#.00");
        String gradoLong;

        String gradosLat[] = String.valueOf(latitud).replace(".", ",").split(",");
        String gradoLat = gradosLat[0];
        String minutosLat = String.valueOf(Integer.parseInt(gradosLat[1]) * 60).substring(0,2);
        String segundos = String.valueOf(Integer.parseInt(gradosLat[1]) * 60).substring(2,5);
        String segundosLat = String.valueOf(Integer.parseInt(segundos)*60).substring(0,2);

        String gradosLong[] = String.valueOf(longitud).replace(".", ",").split(",");
        if (Integer.parseInt(gradosLong[0]) < 0) {
            gradoLong = String.valueOf(Integer.parseInt(gradosLong[0]) - (Integer.parseInt(gradosLong[0])*2));
        } else {
            gradoLong = gradosLong[0];
        }
        String minutosLong = String.valueOf(Integer.parseInt(gradosLong[1]) * 60).substring(0,2);
        String segundosLo = String.valueOf(Integer.parseInt(gradosLong[1]) * 60).substring(2,5);;
        String segundosLong =  String.valueOf(Integer.parseInt(segundosLo)*60).substring(0,2);

        String ubicacionSexagesimal = gradoLat + "°" + minutosLat + "'" + segundosLat + "\"N, "
                + gradoLong + "°" + minutosLong + "'" + segundosLong + "\"O";

        return ubicacionSexagesimal;

    }
}
