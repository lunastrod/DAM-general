package com.dam.feb3;

public class Banio extends Estancia {
    private boolean ducha;
    private boolean banera;
    
    public Banio(String nombre, double metrosCuad, int numPuertas, int numVentanas, boolean ducha, boolean banera) {
        super(nombre, metrosCuad, numPuertas, numVentanas);
        this.ducha = ducha;
        this.banera = banera;
    }

    @Override
    public String toString() {
        String tieneDucha = ducha ? "Si" : "No";
        String tieneBanera = banera ? "Si" : "No";

        return super.toString() + " | Banio [Ducha: " + tieneDucha + ", Banera: " + tieneBanera + "]";
    }
}