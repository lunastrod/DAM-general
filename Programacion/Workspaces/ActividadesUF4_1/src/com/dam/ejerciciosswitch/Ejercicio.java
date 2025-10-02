package com.dam.ejerciciosswitch;
/*
 * solicitar la nota de un examen teniendo que ser esta nota
 * un valor entero
 * mostrar por consola la nota en texto correspondiente
 * 
 * 
 * 
 * */

import java.util.Scanner;

public class Ejercicio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nota");
		int nota=Integer.parseInt(sc.nextLine());
		sc.close();
		
		switch(nota) {
			case 10:
			case 9:
				System.out.println("Sobresaliente");
				break;
			case 8:
			case 7:
				System.out.println("Notable");
				break;
			case 6:
				System.out.println("Bien");
				break;
			case 5:
				System.out.println("Suficiente");
				break;
			case 4:
			case 3:
			case 2:
			case 1:
			case 0:
				System.out.println("Suspenso");
				break;
			default:
				System.out.println("Nota no válida");
				break;
		}


	}

}
