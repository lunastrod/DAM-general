package com.dam.ejercicios;

import java.util.Scanner;

/*
 * Realiza un programa que solicite el número de horas, el número de minutos y el
   número de segundos e indique por consola cuántos segundos son en total.
 * 
 * 
 * */

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce horas");
		String input=sc.nextLine();
		int horas = Integer.parseInt(input);
		System.out.println("Introduce minutos");
		input=sc.nextLine();
		int minutos = Integer.parseInt(input);
		System.out.println("Introduce segundos");
		input=sc.nextLine();
		int segundos = Integer.parseInt(input);
		System.out.println(horas*3600+minutos*60+segundos+" segundos");
		sc.close();
	}

}
