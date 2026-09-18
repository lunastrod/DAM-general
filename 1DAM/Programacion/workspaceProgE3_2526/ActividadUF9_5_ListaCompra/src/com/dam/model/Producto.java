package com.dam.model;

public class Producto {
	public static final String[] UNIDADES = {"Kg", "g", "l", "ml", "Ud"};
	
	private String nombre;
	private int cantidad;
	private String unidad;
	
	public Producto(String nombre, int cantidad, String unidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}

	@Override
	public String toString() {
		return nombre + " - " + cantidad + " " + unidad;
	}
	
	

}
