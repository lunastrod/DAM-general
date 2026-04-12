package com.dam.model;

public class Ecuacion2G {
	// ax^2 + bx + c = 0
	private int a; // término x cuadrado
	private int b;  // término x
	private int c; // término independiente
	
	public Ecuacion2G(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// retornamos un array porque una ecuación de segundo
	// grado puede tener dos posible soluciones
	public Double[] resolverEcuacion() {
		// x[0] = -b + Math.sqrt(b*b - 4*a*c) / 2*a
		// x[1] = -b - Math.sqrt(b*b - 4*a*c) / 2*a
		Double[] x = new Double[2];
		
		if (a != 0 && (b*b - 4*a*c) >= 0) {
			// podemos calcular las soluciones
			x[0] = -b + Math.sqrt(b*b - 4*a*c) / 2*a;
			x[1] = -b - Math.sqrt(b*b - 4*a*c) / 2*a;
		}
		
		return x;
		
	}

}
