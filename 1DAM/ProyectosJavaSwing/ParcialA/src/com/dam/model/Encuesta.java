package com.dam.model;

import java.util.ArrayList;

public class Encuesta {
    public static final String[] FRECUENCIAS = {"Ninguna", "1 o 2 veces por semana", "3 o 4 veces por semana", "5 o 6 veces por semana", "Todos los dias"};
    public static final String[] FRECUENCIAS_CORTO = {"0 v/s", "1 o 2 v/s", "3 o 4 v/s", "5 o 6 v/s", "Todos"};
    public static final String[] EDAD = {"Entre 5 y 17", "Entre 18 y 30", "Entre 31 y 40", "Entre 41 y 65", "Más de 65"};
    public static final String[] SERIES = {"Juego de Tronos", "Vikingos", "Breaking Bad", "Stranger Things", "El Cuento de la Criada", "El Juego del Calamar", "Dragon Ball", "7 vidas"};
    private String edad;
    private String frecuencia;
    private ArrayList<String> series;

    public Encuesta(String edad, String frecuencia, ArrayList<String> series) {
        this.edad = edad;
        this.frecuencia = frecuencia;
        this.series = series;
    }

    public String getEdad() {
        return edad;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public ArrayList<String> getSeries() {
        return series;
    }

    private String getFrecuenciaCorto(String frecuencia) {
        switch (frecuencia) {
            case "Ninguna":
                frecuencia = Encuesta.FRECUENCIAS_CORTO[0];
                break;
            case "1 o 2 veces por semana":
                frecuencia = Encuesta.FRECUENCIAS_CORTO[1];
                break;
            case "3 o 4 veces por semana":
                frecuencia = Encuesta.FRECUENCIAS_CORTO[2];
                break;
            case "5 o 6 veces por semana":
                frecuencia = Encuesta.FRECUENCIAS_CORTO[3];
                break;
            case "Todos los dias":
                frecuencia = Encuesta.FRECUENCIAS_CORTO[4];
                break;
        }
        return frecuencia;
    }

    public String toString() {
        return edad + " - " + getFrecuenciaCorto(frecuencia) + " - Series vistas: " + String.join(", ", series);
    }
}
