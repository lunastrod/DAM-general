package com.dam.ejercicios;

import java.util.Scanner;
/*
 * Realiza un programa que solicite el radio de un cículo y cálcule su área sabiendo que
necesitamos el valor PI = 3.14
 * */

public class Ejercicio2 {
	public static final double PI=3.14;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce radio");
		String input=sc.nextLine();
		double radio=Double.parseDouble(input);
		double area=radio*radio*PI;
		System.out.println(area);
		sc.close();
	}

}
