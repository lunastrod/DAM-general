package com.dam.feb3;

public class Habitacion extends Estancia {
    // Attributes changed to private for strict encapsulation
    private int numPuertasArm;
    private boolean accesoBanio;

    public Habitacion(String nombre, double metrosCuad, int numPuertas, int numVentanas, int numPuertasArm,
                    boolean accesoBanio) {
        super(nombre, metrosCuad, numPuertas, numVentanas);
        this.numPuertasArm = numPuertasArm;
        this.accesoBanio = accesoBanio;
    }

    @Override
    public String toString() {
        // Human-friendly boolean conversion
        String tieneBanio = accesoBanio ? "Si" : "No";

        // Building a cleaner string using the parent data
        return super.toString() + " | Habitacion [Puertas Armario: " + numPuertasArm + 
               ", Acceso Bano: " + tieneBanio + "]";
    }
}