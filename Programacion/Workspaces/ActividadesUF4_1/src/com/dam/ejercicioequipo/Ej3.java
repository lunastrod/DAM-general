package com.dam.ejercicioequipo;
//Desarrollar un programa que indique los divisores de un número dado.

import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int n=Integer.parseInt(sc.nextLine());
		sc.close();
		for(int i=1; i<n; i++) {
			if(n%i==0) {
				System.out.println("Encontrado divisor: "+ i);
			}
		}
	}

}
