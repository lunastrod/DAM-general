package com.dam.dic10.a.ej2.pojo;

public class Estacion {
	
	public static final String[] ESTADOS = {"ABIERTA", "CERRADA"};
	
	private String nombre;
	private String provincia;
	private String estado;
	private String remontes;
	private String pistas;
	private String kmEsquiables;
	
	public Estacion(String nombre, String provincia, String estado, 
			String remontes, String pistas, String kmEsquiables) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.estado = estado;
		this.remontes = remontes;
		this.pistas = pistas;
		this.kmEsquiables = kmEsquiables;
	}
	
	public String getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		String cadena = "\n" + nombre + "(" + provincia + ")"
				+ "\nEstado: " + estado;
		
		if (estado.equals(ESTADOS[0])) {
			cadena += "\nRemontes: " + remontes + ", Pistas: " + pistas 
					+ ", Km esquiables: " + kmEsquiables;
		}
		
		return cadena;
	}
	
	public double calcularPorcKmEsq() {
		// kmEsquiables = "37/68"
		String[] datos = kmEsquiables.split("/");
		// ["37", "68"]
		
		double kmEsqAbiertos = Double.parseDouble(datos[0]);
		double kmEsqTotales = Double.parseDouble(datos[1]);
		
		/* otra forma de obtener los datos
		int posBarra = kmEsquiables.indexOf("/");
		double kmEsqAbiertos2 = Double.parseDouble(kmEsquiables.substring(posBarra));
		double kmEsqTotales2 = Double.parseDouble(kmEsquiables.substring(posBarra + 1, kmEsquiables.length()));
		*/
		
		return kmEsqAbiertos * 100 / kmEsqTotales;
		
	}
	
	public double kmEsquiablesAbiertos() {
		String[] datos = kmEsquiables.split("/");
		
		return Double.parseDouble(datos[0]);
	}
	
}
