package com.dam.dic10.pojos;

public class ActividadDeportiva {
    private String disciplina;
    private int distancia;//m
    private double tiempo;//min
    private String fecha;

    public static final int MAX_DISTANCIA=100000;
    public static final int MIN_DISTANCIA=60;
    public static final int MAX_TIEMPO=100000;
    public static final int MIN_TIEMPO=60;
    public static final int CHAR_FECHA=16;
    public static final String[] DISCIPLINAS={"Carrera","Bicicleta","Natacion"};

    public ActividadDeportiva(String disciplina, int distancia, double tiempo, String fecha) {
        this.disciplina = disciplina;
        this.distancia = distancia;
        this.tiempo = tiempo;
        this.fecha = fecha;
    }

    public int getDistancia() {
        return distancia;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Actividad: ");
        sb.append(disciplina);
        sb.append("\nDistancia: ");
        sb.append(distancia);
        sb.append(" m, Tiempo: ");
        sb.append(tiempo);
        sb.append(" min\nFecha: ");
        sb.append(fecha);
        return sb.toString();
    }
}
