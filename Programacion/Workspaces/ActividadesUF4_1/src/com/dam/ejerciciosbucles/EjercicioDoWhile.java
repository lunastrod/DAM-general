package com.dam.ejerciciosbucles;

import java.util.Random;
import java.util.Scanner;

public class EjercicioDoWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero");
		Random r= new Random();
		int n=Integer.parseInt(sc.nextLine());
		int aleatorio=1;
		System.out.print("Calculos: ");
		do {
			
			aleatorio=r.nextInt(0, n);
			System.out.print(aleatorio+" ");
			
		}while(aleatorio%2!=0);
		System.out.println("\naleatorio par menor que "+n+": "+aleatorio);
		sc.close();

	}

}
