package com.dam.ejercicioequipo;
//Realiza un programa para obtener un número aleatorio múltiplo de 7
//menor que el que se indique por teclado.

import java.util.Random;
import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int n=Integer.parseInt(sc.nextLine());
		sc.close();
		
		Random rd = new Random();
		int aleatorio;
		do {
			aleatorio=rd.nextInt(0,n);
		}
		while(aleatorio%7!=0);
		System.out.println("numero aleatorio menor que n multiplo de 7: "+aleatorio);
	}

}
