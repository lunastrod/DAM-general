package com.dam.dic10.a.ej2.main;

import java.util.Scanner;

import com.dam.dic10.a.ej2.pojo.Estacion;

public class GestionEstaciones {

	static final int MIN_KM_ESQ = 20;
	static Scanner sc;
	static Estacion [] arrayEstaciones;
	
	public static void main(String[] args) {
		/*
• Mostrar la estación abierta con menor porcentaje de km esquiables.
		 */
		
		sc = new Scanner(System.in);
		// 1. solicitar cantidad de estaciones
		int cant = solicitarCantidad();
		
		// 2. Rellenar e inicializar un array para almacenar la información de las estaciones
		almacenarEstaciones(cant);

		sc.close();
		
		// 3. Mostrar los datos de las estaciones junto con el porcentaje de km esquiables para cada estación ABIERTA
		mostrarEstaciones();
		
		// 4. Informar de cuántas estaciones abiertas se han introducido y cuántas tienen más de 20 km esquiables abiertos
		realizarInforme();
		
		// 5. Mostrar la estación abierta con menor porcentaje de km esquiables
		estacionAbMenorPorc();
	}

	private static void estacionAbMenorPorc() {
		Estacion estacionAbMenorPorc = null;
		
		for (int i = 0; i < arrayEstaciones.length; i++) {
			if (arrayEstaciones[i].getEstado().equals(Estacion.ESTADOS[0])) {
				if (estacionAbMenorPorc == null 
						|| arrayEstaciones[i].calcularPorcKmEsq() < estacionAbMenorPorc.calcularPorcKmEsq()) {
					estacionAbMenorPorc = arrayEstaciones[i];
				}
			}
		}
		
		if (estacionAbMenorPorc != null) {
			System.out.println("\nLa estación abierta con menor porcentaje de km esquiables es: " + estacionAbMenorPorc);
		} else {
			System.out.println("\nNo hay estaciones abiertas");
		}
		
	}

	private static void realizarInforme() {
		int contAb = 0;
		int contKmEsAb = 0;
		
		for (int i = 0; i < arrayEstaciones.length; i++) {
			// comprobamos si la estación está abierta
			if (arrayEstaciones[i].getEstado().equals(Estacion.ESTADOS[0])) {
				contAb++;
				
				if (arrayEstaciones[i].kmEsquiablesAbiertos() > MIN_KM_ESQ) {
					contKmEsAb++;
				}
				
			}
						
		}
		
		System.out.println("De " + arrayEstaciones.length + " estaciones, " + contAb + " están abiertas y " 
				+ contKmEsAb + " tienen más de " + MIN_KM_ESQ + " km esquiables");
		
	}

	private static void mostrarEstaciones() {
		System.out.println("*** PISTAS INTRODUCIDAS ***");
		for (int i = 0; i < arrayEstaciones.length; i++) {
			System.out.println(arrayEstaciones[i]);
			
			System.out.println("Porcentaje km esquiables: " + arrayEstaciones[i].calcularPorcKmEsq() + "%");
		}
		
	}

	private static void almacenarEstaciones(int cant) {
		arrayEstaciones = new Estacion[cant];
		
		for (int i = 0; i < arrayEstaciones.length; i++) {
			// solicitar datos
			// inicializas el objeto
			arrayEstaciones[i] = solicitarDatosEstacion(i + 1);
		}
		
	}

	private static Estacion solicitarDatosEstacion(int i) {
		System.out.println("\nIntroduce el nombre de la " + i + "ª estación");
		String nom = sc.nextLine();
		
		System.out.println("Introduce la provincia");
		String prov = sc.nextLine();
		
		System.out.println("Estado: (" + Estacion.ESTADOS[0] + "," + Estacion.ESTADOS[1] + ")");
		String est = sc.nextLine().toUpperCase();
		
		System.out.println("Remontes: ");
		String rem = sc.nextLine();
		
		System.out.println("Pistas: ");
		String pist = sc.nextLine();
		
		System.out.println("Km esquiables: ");
		String kmEs = sc.nextLine();
		
		Estacion estacion = new Estacion(nom, prov, est, rem, pist, kmEs);
		return estacion;
	}

	private static int solicitarCantidad() {
		System.out.println("Indica la cantidad de estaciones que se van a introducir");
		int cant = Integer.parseInt(sc.nextLine());
		
		return cant;
	}

}
