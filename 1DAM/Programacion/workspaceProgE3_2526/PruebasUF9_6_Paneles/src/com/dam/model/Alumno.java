package com.dam.model;

public class Alumno {
	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;

	public Alumno(String nombre, String apellidos, String dni, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos + " (" + edad + ") - " + dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDni() {
		return dni;
	}

	public int getEdad() {
		return edad;
	}

}
