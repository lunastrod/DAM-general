package com.dam.feb3;

public class Hall extends Estancia {
    private boolean puertaBlind;

    public Hall(String nombre, double metrosCuad, int numPuertas, int numVentanas, boolean puertaBlind) {
        super(nombre, metrosCuad, numPuertas, numVentanas);
        this.puertaBlind = puertaBlind;
    }

    @Override
    public String toString() {
        // Converting boolean to the Si/No format without accents
        String esBlindada = puertaBlind ? "Si" : "No";

        return super.toString() + " | Hall [Puerta Blindada: " + esBlindada + "]";
    }
}