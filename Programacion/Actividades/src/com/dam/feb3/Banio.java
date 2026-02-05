package com.dam.feb3;

public class Banio extends Estancia {
    protected boolean ducha;
    protected boolean banera;
    
    public Banio(String nombre, double metrosCuad, int numPuertas, int numVentanas, boolean ducha, boolean banera) {
        super(nombre, metrosCuad, numPuertas, numVentanas);
        this.ducha = ducha;
        this.banera = banera;
    }

    @Override
    public String toString() {
        return "Banio [nombre=" + nombre + ", ducha=" + ducha + ", banera=" + banera + ", metrosCuad=" + metrosCuad
                + ", numPuertas=" + numPuertas + ", numVentanas=" + numVentanas + "]";
    }

}
