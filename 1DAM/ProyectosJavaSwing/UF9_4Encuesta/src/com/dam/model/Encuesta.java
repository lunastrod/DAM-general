package com.dam.model;

public class Encuesta {
    public static final String[] PREGUNTAS={
        "Edad",
        "¿Ha pasado usted el COVID-19?",
        "¿Qué síntomas padeció?",
        "Nivel de gravedad:"
    };

    public static final String[][] RESPUESTAS_POSIBLES={
        {""},
        {"SI", "NO"},
        {"Síntomas respiratorios", "Cansancio/Malestar", "Pérdida de olfato","Pérdida de gusto","Dolor de cabeza", "Fiebre", "Sin síntomas","Tos seca"},
        {"1 - Ninguna", "2 - Leve", "3 - Media", "4 - Alta", "5 - Hospitalización"}
    };

    private int edad;
    private String covid;
    private String sintomas;
    private String gravedad;

    public Encuesta(int edad, String covid, String sintomas, String gravedad) {
        this.edad = edad;
        this.covid = covid;
        this.sintomas = sintomas;
        this.gravedad = gravedad;
    }

    public String toString(){
        return "Edad: "+this.edad+" años    "+
                "¿Ha pasado usted el COVID-19?: "+this.covid+"    "+
                "¿Qué síntomas padeció?: "+this.sintomas+"    "+
                "Nivel de gravedad: "+this.gravedad;
    }
}
