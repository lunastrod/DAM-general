package com.dam.feb3;

public class Cocina extends Estancia {
    private boolean tieneTendedero;
    private double m2Tend;

    public Cocina(String nombre, double metrosCuad, int numPuertas, int numVentanas, 
                  boolean tieneTendedero, double m2Tend) {
        super(nombre, metrosCuad, numPuertas, numVentanas);
        this.tieneTendedero = tieneTendedero;
        
        // Logic: Only assign m2Tend if the laundry area exists
        if (tieneTendedero) {
            this.m2Tend = m2Tend;
        } else {
            this.m2Tend = 0;
        }
    }

    public boolean isTieneTendedero() {
        return tieneTendedero;
    }

    public double getM2Tend() {
        return m2Tend;
    }

    @Override
    public String toString() {
        String textoTendedero = tieneTendedero ? "Si" : "No";
        
        String info = super.toString() + " | Cocina [Tendedero: " + textoTendedero;
        
        // Only show laundry square meters if it exists
        if (tieneTendedero) {
            info += ", Tamano Tendedero: " + m2Tend + " m2]";
        } else {
            info += "]";
        }
        
        return info;
    }
}