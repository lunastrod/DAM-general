package com.dam.feb3;

public class Habitacion extends Estancia{
    protected int numPuertasArm;
    protected boolean accesoBanio;

    public Habitacion(String nombre, double metrosCuad, int numPuertas, int numVentanas, int numPuertasArm,
            boolean accesoBanio) {
        super(nombre, metrosCuad, numPuertas, numVentanas);
        this.numPuertasArm = numPuertasArm;
        this.accesoBanio = accesoBanio;
    }

    @Override
    public String toString() {
        return "Habitacion [nombre=" + nombre + ", numPuertasArm=" + numPuertasArm + ", metrosCuad=" + metrosCuad
                + ", accesoBanio=" + accesoBanio + ", numPuertas=" + numPuertas + ", numVentanas=" + numVentanas + "]";
    }
    
}
