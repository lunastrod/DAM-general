package com.dam.ejerciciosif;

import java.util.Scanner;

/*
Realizar un programa en Java para saber cuándo un año es bisiesto,
utilizando sentencias de tipo if.
Un año es bisiesto si es divisible entre 4 y no es divisible entre 100.
Sin embargo, si un año es divisible entre 100 y además es divisible
entre 400, también resulta bisiesto.
 * */

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero de horas");
		int year=Integer.parseInt(sc.nextLine());
		if(year%400==0) {
			System.out.println("Bisiesto");
		}
		else if(year%100==0) {
			System.out.println("No Bisiesto");
		}
		else if(year%4==0) {
			System.out.println("Bisiesto");
		}
		else {
			System.out.println("No Bisiesto");
		}
		

	}

}
