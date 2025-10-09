package com.dam.ejercicioequipo;
//Escribe un programa que diga si un número introducido por teclado es o no primo.
//Un número primo es aquel que sólo es divisible entre él mismo y la unidad. Nota:
//Es suficiente probar hasta la raíz cuadrada del número para ver si es divisible por
//algún otro número.

import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int n=Integer.parseInt(sc.nextLine());
		sc.close();
		boolean esPrimo=true;
		//99929 es primo
		//99927 no es
		
		for(int i=2; i<Math.sqrt(n); i++) {
			if(n%i==0) {
				esPrimo=false;
				System.out.println("Encontrado divisor: "+ i);
				System.out.println("Encontrado divisor: "+ n/i);
			}
		}
		
		if(esPrimo) {
			System.out.println(n+" es primo");
		}
		else {
			System.out.println(n+" no es primo");
		}
		//Math.sqrt(0);

	}

}
