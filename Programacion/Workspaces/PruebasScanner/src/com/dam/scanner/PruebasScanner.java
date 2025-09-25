package com.dam.scanner;

import java.util.Scanner;

public class PruebasScanner {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("nombre");
		String nombre=teclado.nextLine();
		System.out.println("hola, "+nombre);
		System.out.println("edad");
		teclado.nextLine();
		int edad=teclado.nextInt();
		System.out.println("edad: "+edad);
		teclado.nextLine();
		double d = teclado.nextDouble();
		System.out.println(d);
		
		
		teclado.close();
	}

}
