package com.dam.mar12;
/*
- necesitaremos una clase Producto con 3 atributos: 
nombre(String), 
cantidad(int) y 
unidades(String), 
un constructor y el 
método toString que devuelva el
nombre, la cantidad y las unidades.
*/

public class Producto {
    private String nombre;
    private int cantidad;
    private String unidades;
    public Producto(String nombre, int cantidad, String unidades) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidades = unidades;
    }
    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", cantidad=" + cantidad + ", unidades=" + unidades + "]";
    }

    
}
