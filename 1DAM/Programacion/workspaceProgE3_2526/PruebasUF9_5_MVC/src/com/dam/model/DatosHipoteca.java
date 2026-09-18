package com.dam.model;

public class DatosHipoteca {
	static final int MESES_ANIO = 12;
	
	private double cantidadHipotecada;
	private int duracion; // años
	private double interes;
	
	public DatosHipoteca(double cantidadHipotecada, int duracion, double interes) {
		this.cantidadHipotecada = cantidadHipotecada;
		this.duracion = duracion;
		this.interes = interes;
	}
	
	public double calcularCuota() {
		double interesA = interes / MESES_ANIO / 100;
		int numCuotas = duracion * MESES_ANIO;
		double potencia = Math.pow(interesA + 1, numCuotas);
		
		double cuota = cantidadHipotecada * (interesA * potencia) / (potencia - 1);
		
		return Math.round(cuota * 100) / 100;
	}
	

}
