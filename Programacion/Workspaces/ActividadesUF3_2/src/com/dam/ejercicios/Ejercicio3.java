package com.dam.ejercicios;

import java.util.Scanner;

/*
 * Realiza un programa que solicite un número entero e indique si es par o impar (usa el
operador ternario)
 * 
 * 
 * */

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero");
		String input=sc.nextLine();
		int n = Integer.parseInt(input);
		String resultado=n%2==0?"Es par":"Es impar";
		System.out.println(resultado);
		sc.close();
	}

}
