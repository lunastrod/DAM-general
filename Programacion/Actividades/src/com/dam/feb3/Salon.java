package com.dam.feb3;

public class Salon extends Estancia {
    private int numPuntosRed;
    private boolean tieneTerraza;
    private double m2Terr;

    public Salon(String nombre, double metrosCuad, int numPuertas, int numVentanas, int numPuntosRed,
                 boolean tieneTerraza, double m2Terr) {
        super(nombre, metrosCuad, numPuertas, numVentanas);
        this.numPuntosRed = numPuntosRed;
        this.tieneTerraza = tieneTerraza;
        
        if (tieneTerraza) {
            this.m2Terr = m2Terr;
        } else {
            this.m2Terr = 0; 
        }
    }

    public boolean isTieneTerraza() {
        return tieneTerraza;
    }

    public double getM2Terr() {
        return m2Terr;
    }

    @Override
    public String toString() {
        String terrazaTexto = tieneTerraza ? "Si" : "No";
        
        // Use super.toString() to get Estancia's data and append Salon's specific info
        String info = super.toString() + " | Salon [Internet: " + numPuntosRed + " pts, Terraza: " + terrazaTexto;
        
        // Only show m2Terr if the terrace actually exists
        if (tieneTerraza) {
            info += ", Tamano Terraza: " + m2Terr + "m2]";
        } else {
            info += "]";
        }
        
        return info;
    }
}
