package com.dam.model;

public class RegTablaPrueba {
    private int id;
    private String descripcion;

    public RegTablaPrueba(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public RegTablaPrueba(String descripcion) {
        this.id = 0;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String toString() {
        return "ID: " + id + " DESCRIPCIÓN: " + descripcion;
    }
}
