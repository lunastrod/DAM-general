package com.dam.jan8;

public class Producto {
    String nombre;
    int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
    public String toString() {
        return cantidad+" "+nombre+", ";
    }
}
