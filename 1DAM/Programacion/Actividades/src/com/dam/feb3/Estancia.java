package com.dam.feb3;

public class Estancia {
    protected String nombre;
    protected double metrosCuad;
    protected int numPuertas;
    protected int numVentanas;
    public static final String[] TIPOS_ESTANCIA={"Hall","Cocina","Habitacion","Banio", "Salon"};

    public Estancia(String nombre, double metrosCuad, int numPuertas, int numVentanas) {
        this.nombre = nombre;
        this.metrosCuad = metrosCuad;
        this.numPuertas = numPuertas;
        this.numVentanas = numVentanas;
    }

    public double getMetrosCuad() {
        return metrosCuad;
    }

    @Override
    public String toString() {
        return "Estancia: " + nombre + " [" + metrosCuad + " m2, Puertas: " 
                + numPuertas + ", Ventanas: " + numVentanas + "]";
    }
}
