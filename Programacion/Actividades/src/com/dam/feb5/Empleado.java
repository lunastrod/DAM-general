package com.dam.feb5;

public class Empleado {
    protected String nombre;
    protected String dni;
    protected double salario;

    public static final String [] tiposEmpleados = {"PRODUCCION", "DISTRIBUCION"};

    public Empleado(String nombre, String dni, double salario) {
        this.nombre = nombre;
        this.dni = dni;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }


    @Override
    public String toString() {
        return "Empleado: " + nombre + " [DNI: " + dni + ", Salario: " + salario + "€]";
    }
}
