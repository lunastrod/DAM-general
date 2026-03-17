package com.dam.model;

public class Encuesta {
    private static final String[] PREGUNTAS={
        "Edad",
        "¿Ha pasado usted el COVID-19?",
        "¿Qué síntomas padeció?",
        "Nivel de gravedad:"
    };

    private static final String[][] RESPUESTAS_POSIBLES={
        {""},
        {"SI", "NO"},
        {"Síntomas respiratorios", "Cansancio/Malestar", "Fiebre"},
        {"1", "2", "3", "4", "5"}
    };

    private int edad;
    private String covid;
    private String sintomas;
    private int gravedad;

    public Encuesta(int edad, String covid, String sintomas, int gravedad) {
        this.edad = edad;
        this.covid = covid;
        this.sintomas = sintomas;
        this.gravedad = gravedad;
    }   

    
}
