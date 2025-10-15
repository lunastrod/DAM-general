package com.dam.ejerciciorepeticion;
/*
 * (while o for) Escribir un programa que imprima todos los números pares entre dos
números que se le pidan al usuario.
 * */

import java.util.Scanner;

public class Ej3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero 1");
		int nMayor=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce numero 2");
		int nMenor=Integer.parseInt(sc.nextLine());
		sc.close();
		if(nMayor<nMenor) {// el usuario me los introduce al reves, swap
			int temp=nMenor;
			nMenor=nMayor;
			nMayor=temp;
		}
		
		for(int i=nMenor; i<=nMayor; i++) {
			if(i%2==0){
				System.out.println(i+" ");
			}
		}

	}

}
