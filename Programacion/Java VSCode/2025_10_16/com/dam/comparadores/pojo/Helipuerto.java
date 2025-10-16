package com.dam.comparadores.pojo;

public class Helipuerto {
    private String nombre;
    private double radio;
    private static final double PI = 3.1416;

    public Helipuerto(String nombre, double radio) {
        this.nombre = nombre;
        this.radio = radio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return PI * radio * radio;
    }

    public String toString(){
        return nombre;
    }
}
