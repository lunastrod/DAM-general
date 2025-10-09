package com.dam.ejerciciorepeticion;
/*(do-while) Crea un programa que pida números hasta que se introduzca un cero.
Debe imprimir la suma y la media de todos los números introducidos.*/

import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int suma=0;
		int count=0;
		int num=0;
		do {
			System.out.println("Introduce numero (0 para parar)");
			num=Integer.parseInt(sc.nextLine());
			count++;
			suma+=num;
		}while(num!=0);
		sc.close();
		suma--;//para descontar el 0
		System.out.println("suma: "+suma);
		System.out.println("media: "+suma/count);

	}

}
