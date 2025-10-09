package com.dam.ejerciciosbucles;

import java.util.Scanner;

public class EjercicioWhile3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero de veces");
		int n=Integer.parseInt(sc.nextLine());
		int negativos=0;
		int positivos=0;
		int ceros=0;
		while(n>0) {
			n--;
			System.out.println("Introduce numero");
			int numero=Integer.parseInt(sc.nextLine());
			if(numero>0) {
				positivos++;
			}
			else if(numero<0) {
				negativos++;
			}
			else {//0
				ceros++;
			}
		}
		System.out.println("positivos: "+positivos);
		System.out.println("negativos: "+negativos);
		System.out.println("ceros: "+ceros);
		sc.close();
	}

}
