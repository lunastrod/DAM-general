package com.dam.ejercicioequipo;
//Desarrollar un programa que muestre los múltiplos de 3
//que se encuentren entre dos enteros positivos introducidos por teclado. 
//Hay que tener en cuenta cuál de los dos es mayor.

import java.util.Scanner;

//
public class Ej1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero 1");
		int n1=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce numero 2");
		int n2=Integer.parseInt(sc.nextLine());
		sc.close();
		
		int nMayor;
		int nMenor;
		/*
		if(n1>n2) {//n1 es mayor
			nMayor=n1;
			nMenor=n2;
		}
		else {
			nMayor=n2;
			nMenor=n1;
		}
		*/
		nMayor=(n1>n2)?n1:n2;
		nMenor=(n2>n1)?n1:n2;
		int i=nMenor;
		while(i<=nMayor) {
			i++;
			if(i%3==0) {
				System.out.print(i+" ");
			}
		}

	}

}
