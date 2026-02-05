package com.dam.feb5;

public class EmpleadoProduccion extends Empleado {
    private String turno;
    private double plusNoct;
    String [] turnosValidos = {"MANANA", "TARDE", "NOCHE"};

    public EmpleadoProduccion(String nombre, String dni, double salario, String turno, double plusNoct) {
        super(nombre, dni, salario);
        this.turno = turno.toUpperCase();
        if(this.turno.equals("NOCHE")) {
            this.plusNoct = plusNoct;
        } else {
            this.plusNoct = 0;
        }
    }

    public double getPlusNoct() {
        return plusNoct;
    }

    @Override
    public String toString() {
        return super.toString() + " | tipo: EmpleadoProduccion [Turno: " + turno + ", Plus Nocturno: " + plusNoct + "€]";
    }
}
