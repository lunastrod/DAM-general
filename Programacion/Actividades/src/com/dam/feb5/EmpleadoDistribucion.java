package com.dam.feb5;

public class EmpleadoDistribucion extends Empleado {
    private String zona;

    public EmpleadoDistribucion(String nombre, String dni, double salario, String zona) {
        super(nombre, dni, salario);
        this.zona = zona;
    }

}
