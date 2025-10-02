package com.dam.ejerciciosif;

import java.util.Scanner;

/*
		Un obrero necesita calcular su salario semanal, el cual se obtiene de
		la siguiente manera:
		Si trabaja 40 horas o menos se le paga $16 por hora
		Si trabaja más de 40 horas se le paga $16 por cada una de las
		primeras 40 horas y $20 por cada hora extra.
 */

public class Ejercicio3 {
	public static final int HORAS_BASE=40;
	public static final int HORAS_BASE_SALARIO=16;
	public static final int HORAS_EXTRA_SALARIO=20;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero de horas");
		int horas=Integer.parseInt(sc.nextLine());
		int salarioSemanal;
		if (horas<=HORAS_BASE) {
			salarioSemanal=HORAS_BASE_SALARIO*horas;
		}
		else {
			salarioSemanal=HORAS_BASE_SALARIO*HORAS_BASE+HORAS_EXTRA_SALARIO*(horas-HORAS_BASE);
		}
		System.out.println("Salario semanal: "+salarioSemanal);
	}
}
