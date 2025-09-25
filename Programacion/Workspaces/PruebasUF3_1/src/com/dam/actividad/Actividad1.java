package com.dam.actividad;
import java.util.Scanner;
//Daniel Parra Segovia

public class Actividad1 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double base;
		double altura;
		double area;
		System.out.println("Introduzca base y altura");
		base = teclado.nextDouble();
		altura = teclado.nextDouble();
		area=base*altura/2;
		System.out.println("Area:"+area);
		teclado.close();
	}
}
