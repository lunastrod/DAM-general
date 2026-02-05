package com.dam.feb3;

public class Salon extends Estancia {
    protected int numPuntosRed;
    protected boolean tieneTerraza;
    protected double m2Terr;

    public Salon(String nombre, double metrosCuad, int numPuertas, int numVentanas, int numPuntosRed,
            boolean tieneTerraza, double m2Terr) {
        super(nombre, metrosCuad, numPuertas, numVentanas);
        this.numPuntosRed = numPuntosRed;
        this.tieneTerraza = tieneTerraza;
        this.m2Terr = m2Terr;
    }

    public boolean isTieneTerraza() {
        return tieneTerraza;
    }

    public double getM2Terr() {
        return m2Terr;
    }

    @Override
    public String toString() {
        return "Salon [nombre=" + nombre + ", numPuntosRed=" + numPuntosRed + ", metrosCuad=" + metrosCuad
                + ", tieneTerraza=" + tieneTerraza + ", numPuertas=" + numPuertas + ", m2Terr=" + m2Terr
                + ", numVentanas=" + numVentanas + "]";
    }
}
