package com.dam.ejercicios;

import java.util.Scanner;

/*
 * Realiza un programa que solicite el nombre de un producto, su precio inicial y un
porcentaje de descuento, y calcule y muestre por consola el precio final de dicho
producto.
 * */

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nombre del producto");
		String nombreProducto=sc.nextLine();
		System.out.println("Introduce precio inicial");
		String input=sc.nextLine();
		double precioInicial=Double.parseDouble(input);
		System.out.println("Introduce descuento");
		input=sc.nextLine();
		double porcentajeDescuento=Double.parseDouble(input);
		double precioFinal=precioInicial*(100-porcentajeDescuento)/100;
		System.out.println("precio final de "+nombreProducto+": "+precioFinal);
		sc.close();
	}

}
